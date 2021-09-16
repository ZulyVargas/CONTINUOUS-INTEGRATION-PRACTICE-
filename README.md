# LABORATORIO 5
__Camilo Andrés Pichimata Cárdenas__ 

__Zuly Valentina Vargas Ramirez__

## PARTE I. - JUGANDO A SER UN CLIENTE HTTP

Comando :

2.  
<img src = "img/comando1Telnet.png " >

3. 

    GET /sssss/abc.html HTTP/1.0
    Host: escuelaing.edu.co    
Resultado:

<img src = "img/PrimerTelnet.png " >

Obtuvimos el error **301**, este error indica que el recurso ha sido movido permanentemente. 


_¿Qué otros códigos de error existen?, ¿En qué caso se manejarán?_

Existen los errores 3xx los cuales son errores de redirección, le indican al ciente que los datos han sido transferidos a otra dirección y/o debe intentarlo con una nueva dirección.

Los errores 4xx indican errores que se producen por parte del cliente, como sintaxis incorrecta o datos no encontrados en la dirección indicada. 

Los errores 5xx indican errores que se producen por parte del servidor, tales como tiempo de espera excedido o errores internos entre otros. 

4. 
Comando : 
<img src = "img/comando1Telnet.png " >

GET /html  HTTP/1.1

Host: httpbin.org 

Resultado:
<img src = "img/SegundoTelnet.png ">

 Obtuvimos un mensaje de éxito (200) y se nos mostró el contenido en formato html. 

