# bolsa-valores-back-java

## Aplicação java spring boot com circuit breaker Netflix Hystrix.
Esta aplicação consome uma API da B3 e retorna dados do ticker enviado, de acordo com a data. O ticker e a data devem ser passados na rota como detalho mais abaixo.

- Executar o docker compose na raiz:
  - Cria a imagem da aplicação java
  - Cria a imagem nginx com as configurações de proxy reverso
  - Cria o container nginx com a imagem nginx
  - Cria os 5 containers com a imagem da aplicação java
  - Insere os 6 containers na mesma rede
  - A porta principal de entrada será a 20001 que é onde o nginx foi configurado. O balanceamento fica por conta do nginx.

- Para testar a api
  - Relizar um GET em http:localhost:20001/b3-ticker/[NOME_TICKER]/[DATA YYYY-MM-DD]
  - exemplo: http:localhost:20001/b3-ticker/itub4/2021-05-10

- Existem 2 repositórios frontend que consomem este api.
## Frontend
- Existem duas aplicações que consome esta api.
  ### Aplicação VUE: 
    [bolsa-valores-front-vue](https://github.com/pkreppel/bolsa-valores-front-vue)
  ### Aplicação React com Nextjs:
    [bolsa-valores-front-nextjs](https://github.com/pkreppel/bolsa-valores-front-nextjs)
