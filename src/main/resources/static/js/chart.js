const optionsAdoptions = {
  series: [{
    name: "Valor",
    data: [12, 30, 21, 24, 10, 22, 35, 44, 10, 16, 16, 19]
  }],
  title: {
    text: 'Adoções',
    style: {
      fontSize: '18px'
    }
  },
  chart: {
    fontFamily: 'Poppins, sans-serif',
    height: 350,
    type: 'bar',
  },
  colors: ['#1E4357', '#316F90', '#4090BC', '#509BC3', '#69A9CC'],
  plotOptions: {
    bar: {
      columnWidth: '46%',
      distributed: true,
    }
  },
  responsive: [
    {
      breakpoint: 1150,
      options: {
        title: {
          style: {
            fontSize: '16px'
          }
        },
        plotOptions: {
          bar: {
            horizontal: true,
          }
        },
        yaxis: {
          labels: {
            style: {
              fontSize: '14px'
            }
          }
        }
      }
    }
  ],
  dataLabels: {
    enabled: false
  },
  legend: {
    show: false,
  },
  xaxis: {
    categories: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
    labels: {
      style: {
        fontSize: '14px'
      }
    }
  }
}
const optionsAnimalsReceived = {
  series: [{
    name: "Valor",
    data: [12, 30, 21, 24, 10, 22, 35, 44, 10, 16, 16, 19]
  }],
  title: {
    text: 'Animais recebidos',
    style: {
      fontSize: '18px'
    }
  },
  chart: {
    fontFamily: 'Poppins, sans-serif',
    height: 350,
    type: 'bar',
  },
  colors: ['#1E4357', '#316F90', '#4090BC', '#509BC3', '#69A9CC'],
  plotOptions: {
    bar: {
      columnWidth: '46%',
      distributed: true,
    }
  },
  responsive: [
    {
      breakpoint: 1150,
      options: {
        title: {
          style: {
            fontSize: '16px'
          }
        },
        plotOptions: {
          bar: {
            horizontal: true,
          }
        },
        yaxis: {
          labels: {
            style: {
              fontSize: '14px'
            }
          }
        }
      }
    }
  ],
  dataLabels: {
    enabled: false
  },
  legend: {
    show: false,
  },
  xaxis: {
    categories: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
    labels: {
      style: {
        fontSize: '14px'
      }
    }
  }
}
const optionsComparison = {
  series: [
    {
      name: "Adoções",
      data: [28, 28, 23, 26, 12, 22, 13, 11, 19, 10, 16, 11]
    },
    {
      name: "Recebidos",
      data: [12, 11, 14, 18, 17, 13, 13, 08, 08, 16, 11, 18]
    }
  ],
  title: {
    text: 'Balanço Anual',
    style: {
      fontSize: '18px'
    }
  },
  chart: {
    fontFamily: 'Poppins, sans-serif',
    height: 350,
    type: 'line',
    toolbar: {
      show: true,
      tools: {
        download: true,
        pan: true,
        zoomin: true,
        zoomout: true,
        selection: false,
        zoom: false,
        reset: false,
      }
    }
  },
  colors: ['#1E4357', '#69A9CC'],
  responsive: [
    {
      breakpoint: 425,
      options: {
        title: {
          style: {
            fontSize: '16px'
          }
        },
        chart: {
          toolbar: {
            show: false,
          }
        }
      }
    }
  ],
  dataLabels: {
    enabled: true,
  },
  stroke: {
    curve: 'smooth'
  },
  markers: {
    size: 1
  },
  xaxis: {
    categories: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
    labels: {
      style: {
        fontSize: '14px'
      }
    },
  },
  yaxis: {
    min: 0,
    max: 30,
  },
  legend: {
    position: 'top',
    horizontalAlign: 'right',
    floating: true,
    offsetY: -25,
    offsetX: -5
  }
}

const chartAdoptions = new ApexCharts(document.querySelector('#chart-adoptions'), optionsAdoptions)
const chartAnimalsReceived = new ApexCharts(document.querySelector('#chart-animals_received'), optionsAnimalsReceived)
const chartComparison = new ApexCharts(document.querySelector('#chart-comparison'), optionsComparison)

chartAdoptions.render()
chartAnimalsReceived.render()
chartComparison.render()