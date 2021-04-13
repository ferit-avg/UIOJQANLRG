package com.ferit.uiojqanlrg.ui

import android.app.Dialog
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.ferit.uiojqanlrg.R
import com.ferit.uiojqanlrg.databinding.ActivityMainBinding
import com.ferit.uiojqanlrg.ext.gone
import com.ferit.uiojqanlrg.ext.setupWithNavController
import com.ferit.uiojqanlrg.ext.visible
import com.ferit.uiojqanlrg.ui.base.BaseActivity
import com.ferit.uiojqanlrg.utils.CommonUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    // - Variables - //
    private var currentNavController: LiveData<NavController>? = null

    private var loadingDialog: Dialog? = null

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup navigation bar
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        } // Else, need to wait for onRestoreInstanceState
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Now that BottomNavigationBar has restored its instance state
        // and its selectedItemId, we can proceed with setting up the
        // BottomNavigationBar with Navigation
        setupBottomNavigationBar()
    }

    // - Navigation bar visibility - //
    override fun hideBottomBar() {
        binding.bottomNav.gone()
    }

    override fun showBottomBar() {
        binding.bottomNav.visible()
    }

    override fun setBottomBarBgColor(color: Int) {
        binding.llMain.setBackgroundColor(ContextCompat.getColor(this, color))
    }

    /**
     * Called on first creation and when restoring state.
     */
    private fun setupBottomNavigationBar() {
        //val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)

        val navGraphIds = listOf(
            R.navigation.home,
            R.navigation.search,
            R.navigation.profile
        )

        // Setup the bottom navigation view with a list of navigation graphs
        val controller = binding.bottomNav.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_container,
            intent = intent
        )

        currentNavController = controller
    }

    // - Progress Bar - //
    override fun displayProgressBar(display: Boolean) {
        if (display) {
            showLoading()
        } else {
            hideLoading()
        }
    }

    private fun showLoading() {
        hideLoading()
        loadingDialog = CommonUtils.showLoadingDialog(this)
    }

    private fun hideLoading() {
        loadingDialog?.let { if (it.isShowing) it.cancel() }
    }
}