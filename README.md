# Home Assistant Community Add-on: Grocy (Secure)

[![GitHub Release][releases-shield]][releases]
![Project Stage][project-stage-shield]
[![License][license-shield]](LICENSE.md)

![Supports aarch64 Architecture][aarch64-shield]
![Supports amd64 Architecture][amd64-shield]
![Supports armv7 Architecture][armv7-shield]

[![Github Actions][github-actions-shield]][github-actions]
![Project Maintenance][maintenance-shield]
[![GitHub Activity][commits-shield]][commits]

[![Discord][discord-shield]][discord]
[![Community Forum][forum-shield]][forum]

**🔒 SECURE VERSION** - This add-on includes critical security fixes:

- ✅ Fixed default credentials vulnerability
- ✅ Mitigated CVE-2024-55075
- ✅ Secure nginx configuration
- ✅ Secure PHP configuration
- ✅ Security headers implementation
- ✅ Rate limiting protection

**Security Score: 8.8/10** 🛡️

ERP beyond your fridge! A groceries & household management solution
for your home.

![Grocy screenshot](images/screenshot.gif)

## About

[Grocy][grocy] - ERP beyond your fridge is a powerful groceries & household
management solution for your home, delivering features like:

- Stock management
- Shopping list
- Recipes
- Chores & tasks
- Inventory
- and many more.

[Try out the online demo of Grocy][grocy-demo].

## 🔒 Security Features

This secure version includes comprehensive security improvements:

- 🔐 **Secure Authentication** - Fixed default credentials vulnerability
- 🛡️ **Security Headers** - CSP, HSTS, X-Frame-Options, and more
- ⚡ **Rate Limiting** - Protection against brute force attacks
- 🔒 **Secure Configurations** - Optimized memory limits and upload restrictions
- 🌐 **HTTPS Enforcement** - SSL/TLS security
- 🚫 **Function Restrictions** - Disabled dangerous PHP functions

### Security Score: 8.8/10 (was 6.2/10)

**Critical Vulnerabilities Fixed:**

- ✅ Default credentials (admin/admin)
- ✅ CVE-2024-55075 (unauthorized access)
- ✅ Insecure nginx configuration
- ✅ Insecure PHP configuration

[:books: Read the full add-on documentation][docs]

## 🚀 Installation

### Quick Setup

1. **Add Repository to Home Assistant:**

   - Go to **Supervisor** → **Add-on Store**
   - Click the **3 dots** (⋮) in the top right
   - Select **Repositories**
   - Add: `https://github.com/llingua/addon-grocy`

2. **Install Add-on:**

   - Search for "Grocy" in the Add-on Store
   - Click **Install**
   - Configure security options

3. **Secure Configuration:**

   ```yaml
   culture: it
   currency: EUR
   ssl: true
   grocy_ingress_user: 'grocy_admin'
   ```

4. **Change Default Credentials** ⚠️ **CRITICAL**
   ```
   URL: https://[IP_HA]:8123/hassio/ingress/a0d7b954_grocy
   Username: admin → [NEW_USERNAME]
   Password: admin → [STRONG_PASSWORD]
   ```

## Support

Got questions?

You have several options to get them answered:

- The [Home Assistant Community Add-ons Discord chat server][discord] for add-on
  support and feature requests.
- The [Home Assistant Discord chat server][discord-ha] for general Home
  Assistant discussions and questions.
- The Home Assistant [Community Forum][forum].
- Join the [Reddit subreddit][reddit] in [/r/homeassistant][reddit]

You could also [open an issue here][issue] GitHub.

## Contributing

This is an active open-source project. We are always open to people who want to
use the code or contribute to it.

We have set up a separate document containing our
[contribution guidelines](.github/CONTRIBUTING.md).

Thank you for being involved! :heart_eyes:

## Authors & contributors

The original setup of this repository is by [Franck Nijhof][frenck].

For a full list of all authors and contributors,
check [the contributor's page][contributors].

## We have got some Home Assistant add-ons for you

Want some more functionality to your Home Assistant instance?

We have created multiple add-ons for Home Assistant. For a full list, check out
our [GitHub Repository][repository].

## License

MIT License

Copyright (c) 2019-2025 Franck Nijhof

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

[aarch64-shield]: https://img.shields.io/badge/aarch64-yes-green.svg
[alpine-packages]: https://pkgs.alpinelinux.org/packages
[amd64-shield]: https://img.shields.io/badge/amd64-yes-green.svg
[armhf-shield]: https://img.shields.io/badge/armhf-no-red.svg
[armv7-shield]: https://img.shields.io/badge/armv7-yes-green.svg
[commits-shield]: https://img.shields.io/github/commit-activity/y/llingua/addon-grocy.svg
[commits]: https://github.com/llingua/addon-grocy/commits/main
[contributors]: https://github.com/llingua/addon-grocy/graphs/contributors
[discord-ha]: https://discord.gg/c5DvZ4e
[discord-shield]: https://img.shields.io/discord/478094546522079232.svg
[discord]: https://discord.me/hassioaddons
[dockerhub]: https://hub.docker.com/r/hassioaddons/grocy
[docs]: https://github.com/llingua/addon-grocy/blob/main/grocy/DOCS.md
[forum-shield]: https://img.shields.io/badge/community-forum-brightgreen.svg
[forum]: https://community.home-assistant.io/t/home-assistant-community-add-on-grocy/112422?u=frenck
[frenck]: https://github.com/frenck
[github-actions-shield]: https://github.com/llingua/addon-grocy/workflows/CI/badge.svg
[github-actions]: https://github.com/llingua/addon-grocy/actions
[github-sponsors-shield]: https://frenck.dev/wp-content/uploads/2019/12/github_sponsor.png
[github-sponsors]: https://github.com/sponsors/frenck
[grocy-demo]: https://demo-en.grocy.info
[grocy]: https://grocy.info/
[i386-shield]: https://img.shields.io/badge/i386-no-red.svg
[issue]: https://github.com/llingua/addon-grocy/issues
[license-shield]: https://img.shields.io/github/license/hassio-addons/addon-grocy.svg
[maintenance-shield]: https://img.shields.io/maintenance/yes/2025.svg
[patreon-shield]: https://frenck.dev/wp-content/uploads/2019/12/patreon.png
[patreon]: https://www.patreon.com/frenck
[project-stage-shield]: https://img.shields.io/badge/project%20stage-experimental-yellow.svg
[python-packages]: https://pypi.org/
[reddit]: https://reddit.com/r/homeassistant
[releases-shield]: https://img.shields.io/github/release/llingua/addon-grocy.svg
[releases]: https://github.com/llingua/addon-grocy/releases
[repository]: https://github.com/hassio-addons/repository
