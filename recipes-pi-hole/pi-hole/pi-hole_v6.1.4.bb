SUMMARY = "A black hole for Internet advertisements"
DESCRIPTION = "Pi-hole is a DNS sinkhole that protects your devices from \
unwanted content without installing any client-side software. \
\
- Easy-to-install: our dialogs walk you through the simple installation process \
in less than ten minutes \
- Resolute: content is blocked in non-browser locations, such as ad-laden \
mobile apps and smart TVs \
- Responsive: seamlessly speeds up the feel of everyday browsing by caching DNS \
queries \
- Lightweight: runs smoothly with minimal hardware and software requirements \
- Robust: a command-line interface that is quality assured for interoperability \
- Insightful: a beautiful responsive Web Interface dashboard to view and \
control your Pi-hole \
- Versatile: can optionally function as a DHCP server, ensuring all your \
devices are protected automatically \
- Scalable: capable of handling hundreds of millions of queries when installed \
on server-grade hardware \
- Modern: blocks ads over both IPv4 and IPv6 \
- Free: open source software that helps ensure you are the sole person in \
control of your privacy"

HOMEPAGE = "https://pi-hole.net/"
BUGTRACKER = "https://github.com/pi-hole/pi-hole/issues"

LICENSE = "EUPL-1.2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b88cc6a18c38fa0e92cb1bb7f97b4f8f"

SRC_URI = "git://github.com/pi-hole/pi-hole.git;protocol=https;branch=master;tag=${PV}"
SRCREV = "cef7fd4b02c9ae4314e7478c0d542379bfce7f65"

S = "${WORKDIR}/git"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d ${D}/opt/pihole
    install -m 0755 -t ${D}/opt/pihole ${S}/gravity.sh
    install -m 0755 -t ${D}/opt/pihole ${S}/advanced/Scripts/*.sh
    install -m 0755 -t ${D}/opt/pihole ${S}/advanced/Scripts/COL_TABLE
    install -T -m 0755 ${S}/advanced/Templates/pihole-FTL-prestart.sh ${D}/opt/pihole/pihole-FTL-prestart.sh
    install -T -m 0755 ${S}/advanced/Templates/pihole-FTL-poststop.sh ${D}/opt/pihole/pihole-FTL-poststop.sh

    install -d ${D}/etc/pihole
    install -m 0644 -t ${D}/etc/pihole ${S}/advanced/Templates/logrotate

    install -d ${D}/usr/local/bin
    install -m 0755 -t ${D}/usr/local/bin ${S}/pihole

    install -d ${D}/etc/bash_completion.d/
    install -m 0644 ${S}/advanced/bash-completion/pihole ${D}/etc/bash_completion.d/pihole
}

RDEPENDS:${PN} = "\
    dnsmasq \
    curl \
    pi-hole-ftl \
    pi-hole-web \
    "

FILES:${PN} += "\
    /opt/pihole \
    ${sysconfdir}/pihole \
    ${prefix}/local/bin \
    ${sysconfdir}/bash_completion.d \
    "
