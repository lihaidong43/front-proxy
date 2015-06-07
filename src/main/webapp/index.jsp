<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>

  <button onclick="fetch()" >Fetch Data</button>
  <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
  <script src = 'http://code.jquery.com/jquery-migrate-1.2.1.min.js'></script>
  <script type="text/javascript">

    function fetch(){
      $.get('http://localhost:8080/gradle-demo/service/fetch').then(function(data){
//        var array = JSON.parse(data);
          if(Object.prototype.toString.call(data) === '[object Array]'){
              data.forEach(function(item){
                  document.write(item.title + "<br>");
                  document.write(item.content + "<br><br><br>");
              })
          }else{
              for(var item in data){
                  document.write(data[item] + "<br>");
              }
          }
      })
    }
  </script>
  </body>
</html>
