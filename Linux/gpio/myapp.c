/*
*
* This is myapp based on gpio-demo app
*
* Copyright (C) 2013 - 2016  Xilinx, Inc.  All rights reserved.
*
* Permission is hereby granted, free of charge, to any person
* obtaining a copy of this software and associated documentation
* files (the "Software"), to deal in the Software without restriction,
* including without limitation the rights to use, copy, modify, merge,
* publish, distribute, sublicense, and/or sell copies of the Software,
* and to permit persons to whom the Software is furnished to do so,
* subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included
* in all copies or substantial portions of the Software.
*
* Use of the Software is limited solely to applications:
* (a) running on a Xilinx device, or (b) that interact
* with a Xilinx device through a bus or interconnect.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
* IN NO EVENT SHALL XILINX  BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
* WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
* CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*
* Except as contained in this notice, the name of the Xilinx shall not be used
* in advertising or otherwise to promote the sale, use or other dealings in this
* Software without prior written authorization from Xilinx.
*
*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <errno.h>
#include <fcntl.h>
#include <signal.h>

#define GPIO_ROOT "/sys/class/gpio"
#define ARRAY_SIZE(a) (sizeof(a)/sizeof(a[0]))

/* function prototypes */
static void usage (char *);
static int open_gpio_channel(int);
static int close_gpio_channel(int);
static int set_gpio_direction(int, int, char *);
static int set_gpio_value(int, int, int);
static int get_gpio_value(int, int);
void signal_handler(int);

static enum {NONE, IN, OUT, CYLON, KIT, LEDCOUNT, CPU, SD} gpio_opt = NONE;

static const unsigned long cylon[] = {
	0x00000080, 0x00000040, 0x00000020, 0x00000010,
	0x00000008, 0x00000004, 0x00000002, 0x00000001,
		    0x00000002, 0x00000004, 0x00000008,
	0x00000010, 0x00000020, 0x00000040, 0x00000080,
};

static const unsigned long kit[] = {
	0x000000e0, 0x00000070, 0x00000038, 0x0000001c,
	0x0000000e, 0x00000007, 0x0000000e,
	0x0000001c, 0x00000038, 0x00000070, 0x000000e0,
};

static const unsigned long cpu[] = {
	0x00000001, 0x00000003, 0x00000007, 0x0000000f,
	0x0000001f, 0x0000003f, 0x0000007f, 0x000000ff,
};

static const unsigned long sd[] = {
	0x00000080, 0x000000c0, 0x000000e0, 0x000000f0,
	0x000000f8, 0x000000fc, 0x000000fe, 0x000000ff,
};

static int gl_gpio_base = 0;

static void usage (char *argv0)
{
	char *basename = strrchr(argv0, '/');
	if (!basename)
		basename = argv0;

	fprintf(stderr,
		"Usage: %s [-g GPIO_BASE] COMMAND\n"
		"\twhere COMMAND is one of:\n"
		"\t\t-i\t\tInput value from GPIO and print it\n"
		"\t\t-o\tVALUE\tOutput value to GPIO\n"
		"\t\t-c\t\tCyclic test pattern\n"
		"\t\t-k\t\t KITT test pattern\n"
		"\t\t-l\t\t LED counter pattern\n"
		"\t\t-u\t\t CPU busy rate\n"
		"\t\t-t\t\t SD card transfer rate\n"
		"\tGPIO_BASE indicates which GPIO chip to talk to (The number can be \n"
		"\tfound at /sys/class/gpio/gpiochipN).\n"
		"\tThe highest gpiochipN is the first gpio listed in the dts file, \n"
		"\tand the lowest gpiochipN is the last gpio listed in the dts file.\n"
		"\tE.g.If the gpiochip1011 is the LED_8bit gpio, and I want to turn on \n"
		"\tall LEDs, the command should be:\n"
		"\t\tgpio-demo -g 1011 -o 0xFF\n"
		"\n"
		"\t(c) UMB extended version of gpio-demo\n"
		"\n"
		,  basename);
	exit(-2);
}

static int open_gpio_channel(int gpio_base)
{
	char gpio_nchan_file[128];
	int gpio_nchan_fd;
	int gpio_max;
	int nchannel;
	char nchannel_str[5];
	char *cptr;
	int c;
	char channel_str[5];

	char *gpio_export_file = "/sys/class/gpio/export";
	int export_fd=0;

	/* Check how many channels the GPIO chip has */
	sprintf(gpio_nchan_file, "%s/gpiochip%d/ngpio", GPIO_ROOT, gpio_base);
	gpio_nchan_fd = open(gpio_nchan_file, O_RDONLY);
	if (gpio_nchan_fd < 0) {
		fprintf(stderr, "Failed to open %s: %s\n", gpio_nchan_file, strerror(errno)); 
		return -1;
	}
	read(gpio_nchan_fd, nchannel_str, sizeof(nchannel_str));
	close(gpio_nchan_fd);
	nchannel=(int)strtoul(nchannel_str, &cptr, 0);
	if (cptr == nchannel_str) {
		fprintf(stderr, "Failed to change %s into GPIO channel number\n", nchannel_str);
		exit(1);
	}

	/* Open files for each GPIO channel */
	export_fd=open(gpio_export_file, O_WRONLY);
	if (export_fd < 0) {
		fprintf(stderr, "Cannot open GPIO to export %d\n", gpio_base);
		return -1;
	}

	gpio_max = gpio_base + nchannel;	
	for(c = gpio_base; c < gpio_max; c++) {
		sprintf(channel_str, "%d", c);
		write(export_fd, channel_str, (strlen(channel_str)+1));
	}
	close(export_fd);
	return nchannel;
}

static int close_gpio_channel(int gpio_base)
{
	char gpio_nchan_file[128];
	int gpio_nchan_fd;
	int gpio_max;
	int nchannel;
	char nchannel_str[5];
	char *cptr;
	int c;
	char channel_str[5];

	char *gpio_unexport_file = "/sys/class/gpio/unexport";
	int unexport_fd=0;

	/* Check how many channels the GPIO chip has */
	sprintf(gpio_nchan_file, "%s/gpiochip%d/ngpio", GPIO_ROOT, gpio_base);
	gpio_nchan_fd = open(gpio_nchan_file, O_RDONLY);
	if (gpio_nchan_fd < 0) {
		fprintf(stderr, "Failed to open %s: %s\n", gpio_nchan_file, strerror(errno)); 
		return -1;
	}
	read(gpio_nchan_fd, nchannel_str, sizeof(nchannel_str));
	close(gpio_nchan_fd);
	nchannel=(int)strtoul(nchannel_str, &cptr, 0);
	if (cptr == nchannel_str) {
		fprintf(stderr, "Failed to change %s into GPIO channel number\n", nchannel_str);
		exit(1);
	}

	/* Close opened files for each GPIO channel */
	unexport_fd=open(gpio_unexport_file, O_WRONLY);
	if (unexport_fd < 0) {
		fprintf(stderr, "Cannot close GPIO by writing unexport %d\n", gpio_base);
		return -1;
	}

	gpio_max = gpio_base + nchannel;	
	for(c = gpio_base; c < gpio_max; c++) {
		sprintf(channel_str, "%d", c);
		write(unexport_fd, channel_str, (strlen(channel_str)+1));
	}
	close(unexport_fd);
	return 0;
}

static int set_gpio_direction(int gpio_base, int nchannel, char *direction)
{
	char gpio_dir_file[128];
	int direction_fd=0;
	int gpio_max;
	int c;

	gpio_max = gpio_base + nchannel;
	for(c = gpio_base; c < gpio_max; c++) {
		sprintf(gpio_dir_file, "/sys/class/gpio/gpio%d/direction",c);
		direction_fd=open(gpio_dir_file, O_RDWR);
		if (direction_fd < 0) {
			fprintf(stderr, "Cannot open the direction file for GPIO %d\n", c);
			return 1;
		}
		write(direction_fd, direction, (strlen(direction)+1));
		close(direction_fd);
	}
	return 0;
}

static int set_gpio_value(int gpio_base, int nchannel, int value)
{
	char gpio_val_file[128];
	int val_fd=0;
	int gpio_max;
	char val_str[2];
	int c;

	gpio_max = gpio_base + nchannel;

	for(c = gpio_base; c < gpio_max; c++) {
		sprintf(gpio_val_file, "/sys/class/gpio/gpio%d/value",c);
		val_fd=open(gpio_val_file, O_RDWR);
		if (val_fd < 0) {
			fprintf(stderr, "Cannot open the value file of GPIO %d\n", c);
			return -1;
		}
		sprintf(val_str,"%d", (value & 1));
		write(val_fd, val_str, sizeof(val_str));
		close(val_fd);
		value >>= 1;
	}
	return 0;
}

static int get_gpio_value(int gpio_base, int nchannel)
{
	char gpio_val_file[128];
	int val_fd=0;
	int gpio_max;
	char val_str[2];
	char *cptr;
	int value = 0;
	int c;

	gpio_max = gpio_base + nchannel;

	for(c = gpio_max-1; c >= gpio_base; c--) {
		sprintf(gpio_val_file, "/sys/class/gpio/gpio%d/value",c);
		val_fd=open(gpio_val_file, O_RDWR);
		if (val_fd < 0) {
			fprintf(stderr, "Cannot open GPIO to export %d\n", c);
			return -1;
		}
		read(val_fd, val_str, sizeof(val_str));
		value <<= 1;
		value += (int)strtoul(val_str, &cptr, 0);
		if (cptr == optarg) {
			fprintf(stderr, "Failed to change %s into integer", val_str);
		}
		close(val_fd);
	}
	return value;
}

void signal_handler(int sig)
{
	switch (sig) {
		case SIGTERM:
		case SIGHUP:
		case SIGQUIT:
		case SIGINT:
			close_gpio_channel(gl_gpio_base);
			exit(0) ;
		default:
			break;
	}
}

int main(int argc, char *argv[])
{
	extern char *optarg;
	char *cptr;
	int gpio_value = 0;
	int nchannel = 0;

	int c;
	int i;
// Variable for CPU statitic computations:
	char str[100];
	char cpu_file[128];
	char* token;
	int k = 0;
	int sum = 0;
	int idle;
	int lastSum = 0;
	int lastIdle = 0;
	double busyFraction;
// Variable for SD transfer computations:
	char irq_file[128];
	int done=0;
	int irq;
	int lastIrq = 0;
	double busyIrq;

	opterr = 0;
	
	while ((c = getopt(argc, argv, "g:io:cklut")) != -1) {
		switch (c) {
			case 'g':
				gl_gpio_base = (int)strtoul(optarg, &cptr, 0);
				if (cptr == optarg)
					usage(argv[0]);
				break;
			case 'i':
				gpio_opt = IN;
				break;
			case 'o':
				gpio_opt = OUT;
				gpio_value = (int)strtoul(optarg, &cptr, 0);
				if (cptr == optarg)
					usage(argv[0]);
				break;
			case 'l':
				gpio_opt = LEDCOUNT;
				break;
			case 'c':
				gpio_opt = CYLON;
				break;
			case 'k':
				gpio_opt = KIT;
				break;
			case 'u':
				gpio_opt = CPU;
				break;
			case 't':
				gpio_opt = SD;
				break;
			case '?':
				usage(argv[0]);
			default:
				usage(argv[0]);
				
		}
	}

	if (gl_gpio_base == 0) {
		usage(argv[0]);
	}

	nchannel = open_gpio_channel(gl_gpio_base);
	signal(SIGTERM, signal_handler); /* catch kill signal */
	signal(SIGHUP, signal_handler); /* catch hang up signal */
	signal(SIGQUIT, signal_handler); /* catch quit signal */
	signal(SIGINT, signal_handler); /* catch a CTRL-c signal */
	switch (gpio_opt) {
		case IN:
			set_gpio_direction(gl_gpio_base, nchannel, "in");
			gpio_value=get_gpio_value(gl_gpio_base, nchannel);
			fprintf(stdout,"0x%08X\n", gpio_value);
			break;
		case OUT:
			set_gpio_direction(gl_gpio_base, nchannel, "out");
			set_gpio_value(gl_gpio_base, nchannel, gpio_value);
			break;
		case LEDCOUNT:
#define LEDCOUNT_DELAY_USECS (250000)
			set_gpio_direction(gl_gpio_base, nchannel, "out");
                        i=0;
			for (;;) {
				i++;
				gpio_value= i;
				set_gpio_value(gl_gpio_base, nchannel, gpio_value);
			        usleep(LEDCOUNT_DELAY_USECS);
			}
			break;
		case CYLON:
//#define CYLON_DELAY_USECS (10000)
#define CYLON_DELAY_USECS (500000)
			set_gpio_direction(gl_gpio_base, nchannel, "out");
			for (;;) {
				for(i=0; i < ARRAY_SIZE(cylon); i++) {
					gpio_value=(int)cylon[i];
					set_gpio_value(gl_gpio_base, nchannel, gpio_value);
				        usleep(CYLON_DELAY_USECS);
				}
			}
			break;
		case CPU:
#define CPU_DELAY_USECS (250000)
			set_gpio_direction(gl_gpio_base, nchannel, "out");
			for (;;) {
    				sprintf(cpu_file, "/proc/stat");
    				FILE * cpu_fp= fopen(cpu_file, "r");
    				if (cpu_fp == NULL) {
      					fprintf(stderr, "Failed to open %s: %s\n", 
                                                          cpu_file, strerror(errno));
      					return -1;
    				}
    				k = 0;
    				fgets(str, 100, cpu_fp); //Read first line with CPU data
    				fclose(cpu_fp);
    				token = strtok(str, " "); //Read first token
    				sum = 0;
    				while(token != NULL) { // Go through the whole line
      					token = strtok(NULL, " ");
      					if (token != NULL) {
        					i = atoi(token);
        					sum += i; // Sum of all CPU data
        					if (k==3) idle = i; 
                                               // idle divide by all data gives busy rate
        					k++;
      					}
    				}
    					busyFraction = 8.0 - (idle-lastIdle)*8.0/(sum-lastSum); 
                                                                            // Scale for 8 LEDs
    				        if (busyFraction>7) busyFraction=7;
    					i = (int) busyFraction;
//    					printf("CPU Busy for : %d / 8 of the time:%d...%d\n", 
//                                                             i, sum-lastSum,idle-lastIdle);
    					lastIdle = idle;
    					lastSum = sum;
					gpio_value = (int)cpu[i];
					set_gpio_value(gl_gpio_base, nchannel, gpio_value);
				        usleep(CPU_DELAY_USECS);
			}
			break;
		case SD:
#define SD_DELAY_USECS (250000)
			set_gpio_direction(gl_gpio_base, nchannel, "out");
			for (;;) {
    				sprintf(irq_file, "/proc/interrupts");
    				FILE * irq_fp = fopen(irq_file, "r");
    				if (irq_fp == NULL) {
      					fprintf(stderr, "Failed to open %s: %s\n", 
                                                        irq_file, strerror(errno));
      					return -1;
    				}
    				done=0;
    				while (done==0) {
      					k = 0;
      					if (fgets(str, 100, irq_fp) == NULL) {
        					printf("mmc0 not found !\n"); 
                                                done = 1;//If no mmc0 when EOF is reached
      					} else {
//      printf("--Line: %s", str); // debug only
        					if (strstr(str, "mmc0") != NULL) {
          						done = 1; // Found the SD card line
          						token = strtok(str, " ");
          						token = strtok(NULL, " "); // second token has irq
//        printf("%d) Token=%s \n",k, token); // debug only
          						irq  = atoi(token);
//        printf("irq=%d\n",irq); // debug only
        					}
      					}
    				}
    				fclose(irq_fp);
    				busyIrq = (irq -lastIrq)*7.0/10; 
                                             // Scale irq by typical idle rate
    				if (busyIrq>7) busyIrq=7;
				i = (int) busyIrq;		
//    				printf("SD Busy for : %d / 8 of the time:%d...%d\n",
//                                                                       i,irq,lastIrq);
    				lastIrq = irq;
				gpio_value=(int)sd[i];
				set_gpio_value(gl_gpio_base, nchannel, gpio_value);
			       	usleep(SD_DELAY_USECS);
			}
			break;
		case KIT:
//#define KIT_DELAY_USECS (10000)
#define KIT_DELAY_USECS (500000)
			set_gpio_direction(gl_gpio_base, nchannel, "out");
			for (;;) {
				for (i=0; i<ARRAY_SIZE(kit); i++) {
					gpio_value=(int)kit[i];
					set_gpio_value(gl_gpio_base, nchannel, gpio_value);
				        usleep(KIT_DELAY_USECS);
				}
			}
			break;
		default:
			break;
	}
	close_gpio_channel(gl_gpio_base);
	return 0;
}


