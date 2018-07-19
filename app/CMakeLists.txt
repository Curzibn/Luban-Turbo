cmake_minimum_required(VERSION 3.4.1)


add_library(
             luban

             SHARED

             src/main/cpp/turbo.c )

include_directories(src/main/cpp/include)

add_library(jpeg SHARED IMPORTED )

set_target_properties(  jpeg
                        PROPERTIES IMPORTED_LOCATION
                        ${CMAKE_SOURCE_DIR}/libs/${ANDROID_ABI}/libjpeg-turbo.a)

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )


target_link_libraries( # Specifies the target library.
                       luban

                       jpeg
                       jnigraphics

                       ${log-lib})
