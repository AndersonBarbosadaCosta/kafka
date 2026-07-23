# Kafka — Estudos e PoC

Repositório para estudos e desenvolvimento de aplicações distribuídas orientadas a eventos usando Apache Kafka. Aqui você encontrará exemplos progressivos, desde os conceitos e exemplos básicos (producers/consumers) até provas de conceito mais avançadas envolvendo Spring Boot, Docker, Kubernetes, Zookeeper e ferramentas de stress test.

## Objetivos

- Criar exemplos práticos em Java usando Spring Boot e Spring Kafka.
- Entender padrões de integração: pub/sub, stream processing (Kafka Streams), exactly-once, transações, particionamento e retenção.
- Aprender a empacotar e executar aplicações com Docker e orquestrar com Kubernetes (incluindo operadores como Strimzi).
- Testar e validar comportamento sob carga usando ferramentas de stress test (kcat, kafka perf tools, JMeter/Locust).
- Documentar configurações de Zookeeper e observar migração/alternativas (KRaft nas versões mais novas do Kafka).

## Estrutura prevista do repositório

- /examples/producer-consumer/ — exemplos básicos (Java + Spring Boot)
- /examples/streams/ — exemplos com Kafka Streams
- /docker/ — Dockerfiles e compose para Kafka + Zookeeper + app
- /k8s/ — manifests e Helm/operador (Strimzi) examples
- /tests/ — scripts e instruções para stress tests
- /docs/ — notas, artigos e referências coletadas

> Obs: Estrutura será preenchida progressivamente conforme os exemplos forem sendo adicionados.

## Começando (prerequisitos)

- Java 11+ (ou versão suportada pelo seu setup)
- Maven ou Gradle
- Docker
- kubectl e (opcional) kind / minikube / k3d para cluster local
- Apache Kafka (pode ser via Docker Compose ou operador Strimzi no Kubernetes)
- Zookeeper (para versões do Kafka que ainda dependem do Zookeeper)

## Exemplos iniciais planejados

1. Producer simples (mensagens JSON) e Consumer simples usando Spring Boot
2. Producer/Consumer com Avro + Schema Registry (Confluent)
3. Exactly-once delivery e transações (producer configs e idempotência)
4. Kafka Streams: transformar e agregar eventos em tempo real
5. Processamento de erros e retry/backoff
6. Deploy em Docker e testes com Compose (Kafka + Zookeeper + app)
7. Deploy em Kubernetes usando Strimzi (operator) e StatefulSets
8. Stress tests e benchmarks (kcat, kafka perf tools, JMeter)

## Como rodar os exemplos (fluxo rápido)

1. Subir Kafka e Zookeeper localmente (ex.: Docker Compose em /docker)
2. Ajustar `application.yml`/`application.properties` do exemplo com o broker address
3. Build do projeto: `./mvnw package` (ou `./gradlew build`)
4. Rodar a aplicação: `java -jar target/app.jar` ou via Docker

Detalhes e scripts específicos serão adicionados em cada pasta de exemplo.

## Ferramentas e utilitários de stress test

- kcat (anteriormente kafkacat) — utilitário CLI para produzir/consumir mensagens e testar tópicos: https://github.com/edenhill/kcat
- Scripts internos do Kafka (producer-perf-test.sh / consumer-perf-test.sh) — para testes de throughput (vem no binário do Kafka)
- Apache JMeter — para cenários de carga customizados: https://jmeter.apache.org/
- Locust — testes de carga programáveis em Python: https://locust.io/

## Zookeeper e KRaft

- Zookeeper é usado por muitas distribuições e versões clássicas do Kafka para coordenação. Documentação: https://zookeeper.apache.org/doc/current/
- Novas versões do Kafka estão introduzindo o modo sem Zookeeper (KRaft). Acompanhar a documentação oficial do Apache Kafka para migração: https://kafka.apache.org/documentation/

## Referências úteis (documentação e artigos)

- Apache Kafka — Documentação oficial: https://kafka.apache.org/documentation/
- Apache Kafka Streams: https://kafka.apache.org/documentation/streams
- Apache Zookeeper — Documentação oficial: https://zookeeper.apache.org/doc/current/
- Confluent — Documentação e guias (Schema Registry, Kafka Connect, etc.): https://docs.confluent.io/
- Spring Boot: https://spring.io/projects/spring-boot
- Spring for Apache Kafka (Spring Kafka): https://spring.io/projects/spring-kafka
- Spring guide — Messaging with Kafka: https://spring.io/guides/gs/messaging-with-kafka
- Baeldung — artigos e tutoriais sobre Spring Kafka: https://www.baeldung.com/spring-kafka
- kcat (kafkacat) — CLI para Kafka: https://github.com/edenhill/kcat
- Strimzi — Kafka Operator para Kubernetes: https://strimzi.io/
- Docker docs: https://docs.docker.com/
- Kubernetes docs: https://kubernetes.io/docs/
- Confluent Blog — artigos e casos de uso: https://www.confluent.io/blog/

Artigos e leituras recomendadas (imersão conceitual):
- "Designing Data-Intensive Applications" — Martin Kleppmann (livro) — arquitetura de sistemas distribuídos e streaming
- Artigos do Confluent e posts técnicos (ver link do blog acima)

## Roadmap (curto/médio prazo)

- [x] README inicial (este arquivo)
- [ ] Exemplo básico Producer/Consumer (Java + Spring Boot)
- [ ] Docker Compose para Kafka + Zookeeper
- [ ] Exemplo com Avro e Schema Registry
- [ ] Exemplo Kafka Streams
- [ ] Deploy no Kubernetes com Strimzi
- [ ] Scripts de stress test e benchmark

## Contribuição

Contribuições são bem-vindas — abra issues para sugestões, bugs ou pedidos de exemplos. Vou iterar e subir exemplos e instruções passo a passo.

## Licença

Por padrão, adicionar uma licença adequada (MIT, Apache-2.0, etc.). Se quiser, posso adicionar um arquivo LICENSE com a licença que preferir.

---

Se quiser, eu já crio o arquivo README.md neste repositório com este conteúdo agora. Posso também adaptar o texto (mais técnico, mais conciso, ou em inglês), ou adicionar logo, badges e exemplos iniciais prontos — me diga como prefere que eu prossiga.