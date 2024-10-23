# Encurtador
Serviço que encurta URls longas deixando-as mais compactas.

## Exemplo

Endpoint para encurtar URL.

**[POST]** `{{host}}/shorten-url`

```json
{
    "url": "https://google.com.br"
}
```

Retorno

```
HTTP/1.1 200 OK
```

```json
{
    "url": "https://xxx.com/DXB6V"
}
```
## Exemplo

Endpoint para ser redirecionado.

**[GET]** `{{host}}/DXB6V`
