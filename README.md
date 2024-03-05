
# Bicho-api

Bichopedia es un caderno de campo alimentado de una api con Spring almacenado en contenedores doker y con un cliente movil de flutter.

En este repositorio podrás encontrar instalar y probar mi api.

## Installation

Para lanzar los contenedores debes tener previamnete instalado docker y maven y seguir los siguientes pasos desde la ruta del proyecto.

En caso de que no tengas el software requerido siga estos enlaces:

https://maven.apache.org/download.cgi

https://docs.docker.com/get-docker/

Contendores
```bash
  docker-compose up -d
```

Esto levantará las BBDD para aceeder a ella por PgAdmin4:

    
    -Pgadmin Login:

        Rute: http://localhost:5050/

        Address: admin@admin.com

        Password: admin

    
    -DB developer:

        HostName: pg_dev
        
        Port: 5432

        Maintenance
        Database: proyecto

        Username: postgres

        Password: 12345678 

    -DB production:

        HostName: pg_prod
        
        Port: 5432

        Maintenance
        Database: proyecto

        Username: postgres

        Password: 12345678 

    
Luego para lanzar la api por el puerto 8080 

```bash
    mvn install
    mvn spring-boot:run
```



