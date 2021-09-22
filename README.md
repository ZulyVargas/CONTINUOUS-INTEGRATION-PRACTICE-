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
En este punto empleamos una consola de Ubuntu para poder emplear los comandos de conteo de caracteres. 

Comando : 

    GET /html  HTTP/1.1
    Host: httpbin.org 

<img src = "img/comando2Telnet.png " >



Resultado:

<img src = "img/SegundoTelnet_2.png ">

 Obtuvimos un mensaje de éxito (200) y se nos mostró el contenido en formato html. 

5. 
Se copia el contenido html obtenido con CTRL + SHIFT + C.

Se crea y pega el contenido en un archivo llamado contenido.txt

Con el comando **wc -c** se puede obtener la cantidad de caracteres del contenido del archivo contenido.txt.


<img src = "img/numeroCaracteres.png ">  

En este caso se obtuvo un total de 3743 caracteres.
  <br/><br/>

 _¿Cuál es la diferencia entre los verbos GET y POST?_

 Tanto el método GET como POST son protocolos HTPP el cual envían al servidor como petición (request) y reciben una respuesta a dicha solicitud (response). 

 El concepto **GET** permite obtener información del servidor. Es decir, traer datos que están almacenadas en el servidor, ya sea una base de datos o archivo al cliente. El concepto **POST** en cambio es enviar información desde el cliente para que sea procesada y actualice o agregue información en el servidor, como sería la carga o actualización. 

_¿Qué otros tipos de peticiones existen?_
 
 Dentro del prótocolo HTTP se encuentran otras peticiones tales como:

 - **HEAD** : La petición HEAD pide una respuesta idéntica a la de una petición GET, pero este solo retorna el encabezado sin el cuerpo de la respuesta.

 - **PUT** : La petición PUT es usado para solicitar que el servidor almacene el cuerpo de la entidad en una ubicación específica dada por el URL.

 - **DELETE** : Esta petición es utilizada para solicitar al servidor que elimine un archivo en una ubicación específica dada por la URL. Este método elimina un recurso determinado.

- **CONNECT** : Esta petición es usada para establecer una conexión de red con un servidor web mediante HTTP.

Información tomada de :

https://yosoy.dev/peticiones-http-get-post-put-delete-etc/

https://developer.mozilla.org/es/docs/Web/HTTP/Methods


6.
Comando curl :

    curl www.httpbin.org 

<img src = "img/curl_1.png "> 
<br/><br/>
Comando curl -v:

    curl -v www.httpbin.org

<img src = "img/curl_v.png "> 
<br/><br/>

Comando curl -i:

    curl -v www.httpbin.org

<img src = "img/curl_i.png "> 
<br/><br/>

EL comando **curl -v** nos permite obtener el encabezado de la solicitud y el número de la respuesta obtenida.El modo detallado -v también hará que curl muestre todos los encabezados que envía y recibe. Permite visualizar la petición GET y el Host realizado para obtener el contenido.


El comando **curl -i** incluye el encabezado HTTP en la salida. El encabezado HTTP incluye cosas como nombre del servidor, fecha del documento, versión HTTP etc.

El comando **curl** retorna únicamente el contenido del recurso solicitado.

Información tomada de:

https://everything.curl.dev/usingcurl/verbose

https://coderwall.com/p/f3avyq/include-http-headers-in-curl-response
<br/><br/>

## PARTE II. - HACIENDO UNA APLICACIÓN WEB DINÁMICA A BAJO NIVEL.

___I. Cree un proyecto maven nuevo usando el arquetipo de aplicación Web estándar maven-archetype-webapp:___

Creamos el proyecto con el siguiente comando:

    mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-webapp

Luego completamos los datos solicitados como se puede ver en la siguiente imagen

<img src = "img/CreacionProyectoServlet.png"> 


### **Estructura del proyecto**

<img src = "img/EstructuraProyecto.png">
<br/><br/>

_1. Revise la clase SampleServlet, e identifique qué hace:_

La clase SampleServlet que extiende a HttpServlet permite mediante el método doGet recibir una petición de usuario y dar una respuesta a este.

_4. Compile y ejecute la aplicación en el servidor embebido Tomcat_

Para compilar y ejecutar empleamos los siguientes comandos respectivamente

    mvn package 
    mvn tomcat7:run

_5. Abra un navegador, y en la barra de direcciones ponga la URL con la cual se le enviarán peticiones al ‘SampleServlet’_

<img src = "img/5-ResultadoConsulta.png">
<br/><br/>

_6. Observe que el Servlet ‘SampleServlet’ acepta peticiones GET, y opcionalmente, lee el parámetro ‘name’_

<img src = "img/6-ResultadoConsulta.png">
<br/><br/>

_15. Probando funcionalidades_

- Prueba Id existente

<img src = "img/15-IdExistente.png">
<br/><br/>

- Prueba Id no existente

<img src = "img/15-IdNoExistente.png">
<br/><br/>

- Prueba sin especificar Id

<img src = "img/15-RequerimientoInvalido.png">
<br/><br/>

- Prueba Id Iválido

<img src = "img/15-IdInvalido.png">
<br/><br/>

## PARTE III.

_18. Prueba del Formulario usando el método post_

<img src = "img/PruebaFormulario.png">
<br/><br/>

_20. Cambie el formulario para que ahora en lugar de POST, use el método GET. ¿Qué diferencia observa?_

Al realizar el cambio y probar nuevamente, el resultado es el mismo, esto se debe a que la implemetación de los 2 métodos es la mima.

_21. ¿Qué se está viendo?_

Cuando se ingresa en el espacio un valor diferente a un número válido se muestra una advertencia indicándonos que el valor ingresado no es un valor de tipo numérico. Si el valor ingresado es válido se muestran los datos solicitados como se ve a continuación:

<img src = "img/21-ConsultaValida-1.png">

<img src = "img/21-ConsultaValida-2.png">
<br/><br/>