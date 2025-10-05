SUMMARY = "Pi-hole dashboard for stats and more"
DESCRIPTION = "Pi-hole is a DNS sinkhole that protects your devices from \
unwanted content without installing any client-side software."
HOMEPAGE = "https://pi-hole.net/"
BUGTRACKER = "https://github.com/pi-hole/web/issues"

LICENSE = "EUPL-1.2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e0fbee952ed27d972a79a2a0e23427de"

SRC_URI = "git://github.com/pi-hole/web.git;protocol=https;branch=master;tag=${PV}"
SRCREV = "cc1cc2859ecb543e3cf7f1874e8a74ef0bd49b8a"

S = "${WORKDIR}/git"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d ${D}/var/www/html/admin
    cp -r ${S}/* ${D}/var/www/html/admin
}
