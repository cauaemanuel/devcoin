
# 🚀 Plataforma de Cotações de Moedas & Criptoativos 💰📈

---

## ✨ Descrição

Bem-vindo à **Plataforma de Cotações** — uma API backend super poderosa que:

* Busca cotações em tempo real de moedas (USD, EUR, BRL) e criptoativos (BTC, ETH)
* Armazena tudo no MongoDB para histórico e performance
* Usa cache para não sobrecarregar APIs externas ⚡
* Executa operações assíncronas para deixar tudo rápido e leve 🚀
* Faz buscas paralelas com threads para ganhar tempo ⏱️

Se liga que é tecnologia top: **Spring Boot + OpenFeign + MongoDB + Cache + Async + Multithreading!**

---

## 🛠️ Tecnologias Usadas

* Java 17+ ☕
* Spring Boot (Web, Data MongoDB, Cache, Async) 🌱
* Spring Cloud OpenFeign 🌐
* MongoDB 🗄️
* Feign Interceptors (Headers, autenticação, logs) 🔐

---

## 🚀 Como Rodar

1. Clone o projeto
2. Configure o MongoDB local ou via Docker 🐋
3. Ajuste a URI do MongoDB no arquivo de config
4. Execute a aplicação:

```bash
./mvnw spring-boot:run
```

5. Teste o endpoint:

```http
GET http://localhost:8080/stock/PTR4
```

---

## 🎯 Exemplos de Endpoint

* Buscar cotação única:

```http
GET /stock/{symbol}
```

---


## 📬 Fale Comigo!

Quer ajuda para começar, ou deseja sugestões para evoluir o projeto? Me chama! 💬


