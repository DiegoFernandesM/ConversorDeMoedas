# 
# Conversor de Moedas

Este projeto é um Conversor de Moedas em Java que utiliza a API [ExchangeRate API](https://www.exchangerate-api.com) para obter as taxas de câmbio mais recentes entre diferentes moedas. A aplicação permite que o usuário selecione a moeda de origem, a moeda de destino e o valor a ser convertido, exibindo o resultado em uma interface de console.

## Funcionalidades

- Obter taxas de câmbio atualizadas em tempo real.
- Conversão entre múltiplas moedas: Dólar Americano (USD), Real Brasileiro (BRL), Peso Argentino (ARS), entre outras.
- Interface de console interativa.
- Tratamento de erros e validações para garantir a confiabilidade dos dados.

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter:

- **Java 11** ou superior instalado
- Dependência **Gson** para manipulação de JSON
- Uma chave de API válida da [ExchangeRate API](https://www.exchangerate-api.com)

## Estrutura do Projeto

O projeto é organizado nas seguintes classes:

- `ConversorMoedaApp`: Classe principal que inicializa o aplicativo e lida com a interação com o usuário.
- `APIService`: Classe responsável por realizar a comunicação com a API de taxas de câmbio e obter as taxas atualizadas.
- `ConversorDeMoedasConsole`: Classe que realiza a lógica de conversão com base nas taxas obtidas.

## Configuração

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/nome-do-repositorio.git
   cd nome-do-repositorio

   
Escolha a moeda de origem:
1. USD
2. BRL
3. ARS
...
Digite o número correspondente à moeda de origem: 1

Escolha a moeda de destino:
1. USD
2. BRL
3. ARS
...
Digite o número correspondente à moeda de destino: 2

Digite o valor a ser convertido: 100
100 USD é igual a 510 BRL

Deseja realizar outra conversão? (s/n): n
Conversor encerrado.


            Possíveis Melhorias
Adicionar interface gráfica para melhorar a usabilidade.
Suporte a mais moedas e integração com outras APIs de taxas de câmbio.
Adicionar testes unitários para validar a lógica de conversão e a interação com a API.
