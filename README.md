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

5. 

 _¿Cuál es la diferencia entre los verbos GET y POST? ¿Qué otros tipos de peticiones existen?_

 Tanto el método GET como POST son protocolo HTPP el cual envía al servidor como petición (request) y recibe una respuesta a dicha solicitud (response). 

 El concepto **GET** es obtener información del servidor. Traer datos que están almacenadas en el servidor, ya sea una base de datos o archivo al cliente. El concepto **POST** en cambio es enviar información desde el cliente paraa que sea procesada y actualice o agregue información en el servidor, como sería la carga o actualización en si de un artículo. 

 
 ## PARTE II. - HACIENDO UNA APLICACIÓN WEB DINÁMICA A BAJO NIVEL.