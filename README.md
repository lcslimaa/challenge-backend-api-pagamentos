# challengeWirecard
API de pagamentos, desenvolvida para o desafio técnico backend da Wirecard Brasil

## Objetivo
Meu desafio nesse projeto era recriar uma pequena parte da Wirecard, ou seja uma API de métodos de pagamento com opções de cartão de crédito e boleto, conforme foi descrito https://github.com/wirecardBrasil/challenge/tree/master/backend.

## Como executar

Para utilizar a API é necessário ter a JDK8 e Maven para execução e ter este esse repositório clonado.
Em seguida só utilizar em sua IDE de preferência

## Tecnologias utilizadas

- [Java 8](https://www.java.com/pt_BR/download/faq/java8.xml)- Versão do Java
- [Spring-boot](https://projects.spring.io/spring-boot/) (v2.1.9.RELEASE) - Framework para desenvolvimento de aplicações web
- [Maven](https://maven.apache.org/) (Apache Maven v4.0.0) - Ferramente de gerenciamento de build
- [H2](https://www.h2database.com/html/main.html) - Banco de dados em memória.
- [IntelliJ](https://www.jetbrains.com/idea/) - IDE utilizada no desenvolvimento.

## Testando os serviços
Para testar os recursos da api utilize as collections do Postman ou os endpoints abaixo.

Para processar um pagamento: 
``` POST http://localhost:8080/api/payments```

Com cartão de crédito:

``` JSON 
{
	"client": {
		"id": 1
	},
	"buyer": {
		"name": "Lucas Lima",
		"email": "teste@teste.com",
		"cpf": "250.926.280-73"
	},
	"payment": {
		"amount": 770.00,
		"paymentMethod": "CREDIT_CARD",
		"card": {
			"cardHolderName": "Lucas Lima",
			"cardNumber": "6062829659167013",
			"cardExpirationDate": "11/08/2021",
			"cardCVV": 260
		}
	}
}
```

Com boleto:

``` JSON 
{
	"client": {
		"id": 1
	},
	"buyer": {
		"name": "Victor Castanho",
		"email": "victor@teste.com",
		"cpf": "030.820.890-03"
	},
	"payment": {
		"amount": 250.00,
		"paymentMethod": "BILLET"
	}
}
 ```
 
 Para consultas de transações por ID:
 ``` GET http://localhost:8080/api/payments/1```
 
 Para retornar todas as transações:
 ``` GET http://localhost:8080/api/payments```
 
 ## Considerações Finais
 
 Agradeço a WireCard pela oportunidade de estar desenvolvendo uma API de pagamentos. Me senti desafiado a fazer desde o inicio e usei boa parte do meu tempo nesse projeto. Acredito que sou um desenvolvedor melhor por ter passado por um desafio como este. Muito obrigado! :)
