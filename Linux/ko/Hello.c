//#define MODULE
#include <linux/module.h>
#include <linux/kernel.h>

int init_module(void){ 
    printk(KERN_INFO "<1> Hello world !\n");
    printk("<1> Hello,World\n");
    return 0;
}

void cleanup_module(void){
    printk(KERN_INFO "<1> Goodbye world.\n");
    printk("<1> Goodbye.\n");
}
