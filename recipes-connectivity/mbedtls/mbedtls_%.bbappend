do_configure:append() {
    sed -i '/#define MBEDTLS_THREADING_C/s*^//**g' ${S}/include/mbedtls/mbedtls_config.h
    sed -i '/#define MBEDTLS_THREADING_PTHREAD/s*^//**g' ${S}/include/mbedtls/mbedtls_config.h
}
