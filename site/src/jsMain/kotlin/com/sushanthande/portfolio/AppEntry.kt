package com.sushanthande.portfolio

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.sushanthande.portfolio.utils.Res
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.scrollBehavior
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.silk.SilkApp
import com.varabyte.kobweb.silk.components.layout.Surface
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.style.common.SmoothColorStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.color
import org.jetbrains.compose.web.css.vh

@App
@Composable
fun AppEntry(content: @Composable () -> Unit) {
    // Apply smooth scrolling to the document
    LaunchedEffect(Unit) {
        js("document.documentElement.style.scrollBehavior = 'smooth'") as Unit
    }

    SilkApp {
        Surface(SmoothColorStyle.toModifier().minHeight(100.vh).scrollBehavior(ScrollBehavior.Smooth)) {
            content()
        }
    }
}

@InitSilk
fun overrideSilkTheme(context: InitSilkContext) {
    context.apply {
        theme.palettes.apply {
            light.apply {
                color = Res.Colors.GREEN_VOGUE
                background = Res.Colors.WHITE
            }
            dark.apply {
                color = Res.Colors.WHITE
                background = Res.Colors.GREEN_VOGUE
            }
        }
    }
}
