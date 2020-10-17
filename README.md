Para poder levantar la aplicación de forma local
es posible levantarla como tarea bootRun

para iniciar sesión hay que usar el metodo POST  en con la url
localhost:8080/login
con el siguiente body
{
    "name": "admin",
    "email": "juan@rodriguez.org",
    "password": "Admin123",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
        }
    ]
}
el cual retorna el token para poder acceder e insertar datos en bd 

si se quiere agregar un usuario usar la url localhost:8080/user con el método POST
usando el token del login como header y con el body 

{
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.org",
    "password": "hunter2",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
        }
    ]
}

y esto devuelve:

● En caso de éxito, retorne el usuario y los siguientes campos:
○ id: id del usuario (puede ser lo que se genera por el banco de datos, pero sería más
deseable un UUID)
○ created: fecha de creación del usuario
○ modified: fecha de la última actualización de usuario
○ last_login: del último ingreso (en caso de nuevo usuario, va a coincidir con la fecha
de creación)
○ token: token de acceso de la API (puede ser UUID o JWT)
○ isactive: Indica si el usuario sigue habilitado dentro del sistema.




