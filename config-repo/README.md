# config-repo (fallback de emergencia)

**Fuente de verdad en runtime: MySQL `lex_config.PROPERTIES`** vía config-server perfil `jdbc`
(`CONFIG_SERVER_PROFILE=jdbc`, default).

Usuario JDBC: `lex_config_app` (solo `SELECT`). Esquema: `lex_config` — **no** usar `lex_core` / `lex_app`.

No edites archivos de esta carpeta para cambiar config de ambientes. Cambia la BD con una
migración Flyway en `lexvertex-migrate` bajo `db/migration/lex_config/`
(`INSERT` / `UPDATE` / `DELETE` sobre `PROPERTIES` con `PROFILE` = `default` | `dev` | `prod`).
Ejecutar: `migrate --schema=lex_config`.

| PROFILE | Uso |
|---|---|
| `default` | Compartido |
| `dev` | Localhost (desarrollo) |
| `prod` | VPS / Docker DNS + `*.lexvertex.cloud` |

Clientes locales: `SPRING_PROFILES_ACTIVE=dev`.

## Esta carpeta

Vacía a propósito. Solo existe para el fallback `CONFIG_SERVER_PROFILE=native`
(`spring.cloud.config.server.native.search-locations`). En operación normal (`jdbc`) **no se usa**.

Si necesitas emergencia native, coloca YAML temporales aquí (o apunta `CONFIG_REPO_PATH`);
no regeneres seed JDBC desde YAML.
