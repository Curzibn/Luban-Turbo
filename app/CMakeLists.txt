cmake_minimum_required(VERSION 3.4.1)


add_library( luban
             SHARED
             src/main/cpp/turbo.c )

include_directories(src/main/cpp/include)

add_library( jpeg SHARED IMPORTED )

set_target_properties(  jpeg
                        PROPERTIES IMPORTED_LOCATION
                        ${CMAKE_SOURCE_DIR}/libs/${ANDROID_ABI}/libjpeg-turbo.a )

find_library( log-lib log )

target_link_libraries( luban

                       jpeg
                       jnigraphics

                       ${log-lib})
