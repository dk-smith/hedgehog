package dk.apps.hedgehog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import dk.apps.hedgehog.fragments.ApiInfoFragment
import dk.apps.hedgehog.fragments.JokesFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var jokesFragment: JokesFragment
    private lateinit var apiInfoFragment: ApiInfoFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        jokesFragment = JokesFragment()
        apiInfoFragment = ApiInfoFragment()
        ShowFragment(jokesFragment)
        bottom_nav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.jokes -> ShowFragment(jokesFragment)
                R.id.api_info -> ShowFragment(apiInfoFragment)
            }
            true
        }
    }

    private fun ShowFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply { replace(R.id.frame, fragment); commit() }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && apiInfoFragment.isVisible) {
            apiInfoFragment.onBackKeyDown()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}