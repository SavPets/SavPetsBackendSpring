const options = {
  chart: {
    type: 'bar'
  },
  series: [{
    name: 'sales',
   data: [10,40,45,50,49,60,70,91,125]
  }],
  xaxis: {
    categories: [1991,1992,1993,1994,1995,1996,1997, 1998,1999]
  }
}

const chart = new ApexCharts(document.querySelector("#chart"), options);






chart.render();