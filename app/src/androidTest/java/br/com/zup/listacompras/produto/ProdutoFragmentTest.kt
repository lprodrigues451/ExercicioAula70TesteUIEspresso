package br.com.zup.listacompras.produto

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.hasErrorText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import br.com.zup.listacompras.R

@RunWith(AndroidJUnit4::class)
class ProdutoFragmentTest {

    private fun starFragment() {
        val scenario = launchFragmentInContainer<ProdutoFragment>()
    }

    @Test
    fun errorField_whenNameAndDetailIsEmpty() {
        starFragment()
        onView(withId(R.id.bvAdicionar)).perform(click())
        onView(withId(R.id.etNomeProduto))
            .check(ViewAssertions.matches(hasErrorText("Por favor preencha o campo d nome")))
        onView(withId(R.id.etDetalheProduto))
            .check(ViewAssertions.matches(hasErrorText("Por favor preencha o campo de detalhe")))
    }

    @Test
    fun errorField_whenDetailIsEmpty() {
        starFragment()
        onView(withId(R.id.etNomeProduto)).perform(ViewActions.typeText("Carro"))
        onView(withId(R.id.bvAdicionar)).perform(click())
        onView(withId(R.id.etDetalheProduto))
            .check(ViewAssertions.matches(hasErrorText("Por favor preencha o campo de detalhe")))
    }


}