function histPlot(formId) {
  let histDiv = document.getElementById("histogram-chart");
  let values = [];
  for (let i = 0; i < 20000; i++) { // Build Gauss data
    values[i] = Math.random() + Math.random() + Math.random() 
    + Math.random() + Math.random()+ Math.random()-3;
  }
  let trace = {
    x: values,
    type: 'histogram',
    nbinsx : 25 // max bins
  };
  let data = [trace];
  let layout = {  title: 'Gauss Distribution Plot' };
  Plotly.plot(histDiv, data, layout);
}
