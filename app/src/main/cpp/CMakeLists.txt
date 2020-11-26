cmake_minimum_required(VERSION 3.4.1)

add_library( yuv
             STATIC
             ./source/compare.cc
             ./source/compare_common.cc
             ./source/compare_gcc.cc
             ./source/compare_mmi.cc
             ./source/compare_msa.cc
             ./source/compare_neon.cc
             ./source/compare_neon64.cc
             ./source/convert.cc
             ./source/convert_argb.cc
             ./source/convert_from.cc
             ./source/convert_from_argb.cc
             ./source/convert_to_argb.cc
             ./source/convert_to_i420.cc
             ./source/cpu_id.cc
             ./source/planar_functions.cc
             ./source/rotate.cc
             ./source/rotate_any.cc
             ./source/rotate_argb.cc
             ./source/rotate_common.cc
             ./source/rotate_gcc.cc
             ./source/rotate_mmi.cc
             ./source/rotate_msa.cc
             ./source/rotate_neon.cc
             ./source/rotate_neon64.cc
             ./source/row_any.cc
             ./source/row_common.cc
             ./source/row_gcc.cc
             ./source/row_mmi.cc
             ./source/row_msa.cc
             ./source/row_neon.cc
             ./source/row_neon64.cc
             ./source/scale.cc
             ./source/scale_any.cc
             ./source/scale_argb.cc
             ./source/scale_common.cc
             ./source/scale_gcc.cc
             ./source/scale_mmi.cc
             ./source/scale_msa.cc
             ./source/scale_neon.cc
             ./source/scale_neon64.cc
             ./source/video_common.cc
         )

target_include_directories(yuv PUBLIC
        ./include
        )

target_link_libraries( # Specifies the target library.
                       yuv
                       )
add_library(
        native
        SHARED
        native-lib.cpp
)

target_include_directories(native PUBLIC
        ./include
        )

target_link_libraries( # Specifies the target library.
        native
        yuv
        jnigraphics
        )