# config-repo (fallback de emergencia)

**Fuente de verdad en runtime: MySQL `lex_core.PROPERTIES`** vía config-server perfil `jdbc` (`CONFIG_SERVER_PROFILE=jdbc`, default).

No edites YAML para cambiar config de ambientes en operación normal. Cambia la BD con una migración Flyway en `lexvertex-migrate` (`INSERT`/`UPDATE`/`DELETE` sobre `PROPERTIES` con `PROFILE` = `default` | `dev` | `prod`).

| PROFILE | Uso |
|---|---|
| `default` | Compartido |
| `dev` | Localhost (desarrollo) |
| `prod` | VPS / Docker DNS + `*.lexvertex.cloud` |

Clientes locales: `SPRING_PROFILES_ACTIVE=dev` (default en gateway, identity, etc.).

## YAML de esta carpeta

Espejo de emergencia si alguien arranca config-server con `CONFIG_SERVER_PROFILE=native`. En operación normal (`jdbc`) **no se usan**.

| Archivo | Contenido |
|---|---|
| `gateway-service.yml` | Shared: port, discovery.locator=false, eureka placeholders |
| `gateway-service-dev.yml` | Rutas localhost (`lb://…`, vigilis → `http://localhost:8000`) |
| `gateway-service-prod.yml` | Rutas VPS / host Vigilís |

Si regeneras seed JDBC (`seed_config_properties.py` / V49+), mantén estos YAML alineados con las filas `gateway-service`/`dev|prod`.
