# ✈️ Sistema de Consulta e Marcação de Voos com Sockets em Java

Este projeto implementa um sistema cliente-servidor utilizando **sockets TCP em Java** para simular um processo de **consulta e marcação de voos e assentos**.

## 📌 Objetivo

Criar uma aplicação distribuída simples com dois componentes:

- **Servidor TCP:** controla os voos e assentos disponíveis.
- **Cliente TCP:** envia consultas e solicitações de marcação ao servidor.

### ✅ Servidor

- Mantém estrutura de dados com voos e assentos.
- Responde às requisições de consulta e marcação do cliente.
- Implementa lógica de verificação e reserva de assentos.

## 🔌 Protocolo de Comunicação

A comunicação entre cliente e servidor segue um protocolo simples baseado em strings separadas por ponto e vírgula:

### 📥 Consulta

``text
C;[VOO];[ASSENTO]

https://github.com/IgorMirandolli/socket_controle_passagem_cliente.git
