SUMMARY = "Network-wide ad blocking via your own Linux hardware"
DESCRIPTION = "Pi-hole is a DNS sinkhole that protects your devices from \
unwanted content without installing any client-side software."
HOMEPAGE = "https://pi-hole.net/"
BUGTRACKER = "https://github.com/pi-hole/FTL/issues"

LICENSE = "EUPL-1.2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ad78970d0f0174fa07b68411168b2378"

DEPENDS = "libidn2 libunistring mbedtls nettle xxd-native"

SRC_URI = "git://github.com/pi-hole/FTL.git;protocol=https;branch=master;tag=${PV}"
SRC_URI:append = " file://patch.patch"
SRCREV = "88737f6248cd3df3202eed72aeec89b9fb572631"

S = "${WORKDIR}/git"

inherit cmake
