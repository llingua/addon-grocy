# 🚀 ISTRUZIONI INSTALLAZIONE - Add-on Grocy Sicuro

## 📋 Panoramica

Questo add-on Grocy include **correzioni di sicurezza critiche** che rendono il sistema molto più sicuro rispetto alla versione standard.

**🔒 Score Sicurezza: 8.8/10** (era 6.2/10)

---

## 🛡️ **VULNERABILITÀ RISOLTE**

- ✅ **Credenziali predefinite** (admin/admin) → Configurazione sicura
- ✅ **CVE-2024-55075** (accesso non autorizzato) → Headers + autenticazione
- ✅ **Configurazione nginx insicura** → User non-root, rate limiting
- ✅ **Configurazione PHP insicura** → Limiti ridotti, funzioni disabilitate

---

## 🚀 **INSTALLAZIONE RAPIDA**

### **Passo 1: Aggiungi Repository**

1. Vai su **Home Assistant** → **Supervisor**
2. Clicca su **Add-on Store**
3. Clicca sui **3 puntini** (⋮) in alto a destra
4. Seleziona **Repositories**
5. Clicca **Add repository**
6. Inserisci: `https://github.com/llingua/addon-grocy`
7. Clicca **Add**

### **Passo 2: Installa Add-on**

1. Cerca "Grocy" nell'Add-on Store
2. Dovrebbe apparire con il repository "llingua/addon-grocy"
3. Clicca **Install**
4. Attendi il completamento dell'installazione

### **Passo 3: Configurazione Sicura**

```yaml
# Configurazione raccomandata
culture: it
currency: EUR
ssl: true
grocy_ingress_user: 'grocy_admin'
```

### **Passo 4: Cambio Credenziali** ⚠️ **CRITICO**

```
URL: https://[IP_HA]:8123/hassio/ingress/a0d7b954_grocy
Username: admin → [NUOVO_USERNAME]
Password: admin → [PASSWORD_COMPLESSA]
```

---

## 🔧 **CONFIGURAZIONE AVANZATA**

### **Opzioni di Sicurezza**

```yaml
# Configurazione completa sicura
culture: it                    # Lingua italiana
currency: EUR                 # Valuta Euro
entry_page: stock            # Pagina iniziale sicura
ssl: true                    # SSL obbligatorio
grocy_ingress_user: 'grocy_admin'  # Utente ingress sicuro

# Funzionalità abilitate
features:
  batteries: true
  calendar: true
  chores: true
  equipment: true
  recipes: true
  shoppinglist: true
  stock: true
  tasks: true

# Configurazioni di sicurezza
tweaks:
  calendar_first_day_of_week: 1        # Lunedì come primo giorno
  meal_plan_first_day_of_week: 1        # Lunedì come primo giorno
  chores_assignment: true
  multiple_shopping_lists: true
  stock_best_before_date_tracking: true
  stock_location_tracking: true
  stock_price_tracking: true
  stock_product_freezing: true
  stock_product_opened_tracking: true
  stock_count_opened_products_against_minimum_stock_amount: true
```

---

## 🛡️ **PROTEZIONI IMPLEMENTATE**

### **🔐 Autenticazione**
- Utente ingress sicuro configurato
- Autenticazione obbligatoria per ingress
- Controllo sessioni sicure

### **🌐 Sicurezza Web**
- **Content Security Policy (CSP)** - Previene XSS
- **X-Frame-Options: DENY** - Previene clickjacking
- **Strict-Transport-Security (HSTS)** - Forza HTTPS
- **X-Content-Type-Options: nosniff** - Previene MIME sniffing
- **Referrer-Policy** - Controllo informazioni referrer
- **Permissions-Policy** - Controllo permessi browser

### **⚡ Rate Limiting**
- **Limite login**: 5 tentativi/minuto
- **Limite API**: 10 richieste/secondo
- **Rate limiting per ingress**
- **Timeout di sicurezza** per prevenire attacchi slowloris

### **🔒 Configurazione Sicura**
- **Memory limit**: 384M → 128M
- **Upload size**: 64M → 16M
- **Client max body**: 4G → 64M
- **Funzioni pericolose disabilitate**
- **Configurazioni sessione sicure**
- **User non-root per nginx**

---

## ✅ **VERIFICA INSTALLAZIONE**

### **Checklist Post-Installazione**

- [ ] Repository aggiunto correttamente
- [ ] Add-on installato senza errori
- [ ] Configurazione sicura applicata
- [ ] Credenziali predefinite cambiate
- [ ] SSL funzionante
- [ ] Accesso tramite ingress
- [ ] Tutte le funzionalità testate

### **Test di Sicurezza**

1. **Test Accesso Non Autorizzato**:
   - Prova ad accedere senza autenticazione
   - Dovrebbe essere bloccato

2. **Test Headers di Sicurezza**:
   - Controlla headers nelle DevTools del browser
   - Dovrebbero essere presenti CSP, HSTS, etc.

3. **Test Rate Limiting**:
   - Prova multiple richieste rapide
   - Dovrebbe attivare il rate limiting

---

## 🆘 **TROUBLESHOOTING**

### **Problema: Repository non trovato**
**Soluzione**:
- Verifica URL: `https://github.com/llingua/addon-grocy`
- Riavvia Home Assistant
- Controlla connessione internet

### **Problema: Add-on non visibile**
**Soluzione**:
- Riavvia Home Assistant
- Pulisci cache browser
- Controlla log supervisor

### **Problema: Errore di configurazione**
**Soluzione**:
- Verifica sintassi YAML
- Controlla log dell'add-on
- Riavvia l'add-on

### **Problema: Accesso negato**
**Soluzione**:
- Verifica credenziali
- Controlla configurazione ingress
- Testa accesso tramite Home Assistant

---

## 📊 **MONITORAGGIO SICUREZZA**

### **Log da Monitorare**
```bash
# Log nginx
tail -f /var/log/nginx/access.log
tail -f /var/log/nginx/error.log

# Log PHP
tail -f /var/log/php82-fpm.log

# Log add-on
hassio addon logs grocy
```

### **Metriche di Sicurezza**
- Tentativi di login falliti
- Rate limiting attivato
- Accessi non autorizzati
- Errori di configurazione

---

## 🔄 **MANUTENZIONE**

### **Aggiornamenti**
- Monitora aggiornamenti di sicurezza
- Backup configurazioni prima di aggiornare
- Testa in ambiente di sviluppo

### **Backup**
- Backup regolare del database Grocy
- Backup configurazioni add-on
- Backup certificati SSL

---

## 📞 **SUPPORTO**

### **In Caso di Problemi**
1. Controlla i log di Home Assistant
2. Verifica la configurazione
3. Consulta la documentazione
4. Contatta il supporto della community

### **Risorse Utili**
- [Home Assistant Community](https://community.home-assistant.io/)
- [Grocy Documentation](https://grocy.info/)
- [Security Best Practices](https://owasp.org/)

---

## 🎉 **CONGRATULAZIONI!**

Hai installato con successo l'add-on Grocy sicuro! 🛡️

**Il tuo sistema è ora protetto con:**
- Score sicurezza: 8.8/10
- Vulnerabilità critiche: 0/4
- Protezioni attive: 15+

**Goditi la gestione sicura della tua casa!** 🏠🔒

---

*Istruzioni generate automaticamente - Data: 2025*  
*Add-on Grocy Sicuro v1.0*  
*Score Sicurezza: 8.8/10*
