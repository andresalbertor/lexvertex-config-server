# Env de arranque del config-server

| Archivo | Ambiente | Notas |
|---|---|---|
| [`config-server.dev.env`](config-server.dev.env) | Local / DEV | Password conocida: `lex_config_dev` |
| [`config-server.pdn.env`](config-server.pdn.env) | VPS / PDN | **No va a git** (gitignore). Contiene password generada para `lex_config_app` |
| [`config-server.pdn.env.example`](config-server.pdn.env.example) | Plantilla | Sin secretos |

Solo estas vars son del **bootstrap** del config-server. La config de los demás MS vive en `lex_config.PROPERTIES` (Flyway `lexvertex-migrate --schema=lex_config`).
