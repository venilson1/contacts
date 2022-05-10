# contacts
Crud para ciração de contatos

### Modo test

```
  sudo docker run -p 81:8080 --name contacts-test contacts:v1 

```

### Modo dev

```
sudo docker run -p 81:8080 --name contacts-dev -e APP_PROFILE=dev  contacts:v1 

```


### Modo prod

```
docker run -p 81:8080 --name contacts-heroku -e APP_PROFILE=prod -e DB_URL= -e DB_USERNAME= -e DB_PASSWORD= contacts:v1

```

link para baixar a imagem: https://hub.docker.com/repository/docker/venilson/contacts


# Recursos 

# Contatos [/contatos]

## Listar (List) [GET]

- Response 201 (application/json)

```
    {
        "id": 1,
        "name": "Bob",
        "lastName": "Brown",
        "cpf": "235.588.965-56",
        "email": "bob@gmail.com",
        "phone": "011959058945"
    },
    

```

##  Novo (Create) [POST]

- body 

```
     {
        "name": "Ana",
        "lastName": "Lindia",
        "cpf": "289.789.157-01",
        "email": "ana@gmail.com",
        "phone": "011978459625"
    }

```

- Response 201 (application/json)

```

```

## Detalhar (Read) [GET /contatos/{codigo}]

- Parameters

    codigo (required, number, 1) ... Código do contato
    
  
  - Body

```
  {
    "id": 1,
    "name": "Bob",
    "lastName": "Brown",
    "cpf": "235.588.965-56",
    "email": "bob@gmail.com",
    "phone": "011959058945"
}

```

- Response 404 (application/json) Quando registro não for encontrado.

```
  {
    "timestamp": "2022-05-10T23:23:34.719730Z",
    "status": 404,
    "error": "Resource not found",
    "message": "Entity Not Found",
    "path": "/contatos/10"
}- 

```

## Editar (Update) [PUT /contatos/{codigo}]

- Request (application/json)

```
{
    "name": "nome exemplo",
    "lastName": "exemplo",
    "cpf": "000.000.000-00",
    "email": "nome@gmail.com",
    "phone": "011956000000"
}

```

- Response 200 (application/json) Todos os dados do contato

```
  {
    "name": "nome exemplo",
    "lastName": "exemplo",
    "cpf": "000.000.000-00",
    "email": "nome@gmail.com",
    "phone": "011956000000"
}
```

## Remover (Delete) [DELETE /contatos/{codigo}]

- Parameters

    codigo (required, number, 1) ... Código do contato

- body

```

```

- Response 204(application/json) Sem Conteúdo

```

```




