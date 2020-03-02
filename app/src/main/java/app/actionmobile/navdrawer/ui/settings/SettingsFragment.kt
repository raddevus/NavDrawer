package app.actionmobile.navdrawer.ui.settings

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import app.actionmobile.navdrawer.R
import app.actionmobile.navdrawer.ui.home.HomeViewModel

class SettingsFragment : Fragment() {

    private lateinit var settingsViewModel: SettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("MainActivity", "SettingsFragment...onCreateView()")
        settingsViewModel =
            ViewModelProvider.AndroidViewModelFactory.getInstance(Application())
                .create(SettingsViewModel::class.java)
        val root = inflater.inflate(R.layout.settings_fragment, container, false)
        val textView: TextView = root.findViewById(R.id.settingsText)
        settingsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
