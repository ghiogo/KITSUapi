package com.example.kitsuapi.ui.fragments.manga

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapi.R
import com.example.kitsuapi.base.BaseFragment
import com.example.kitsuapi.databinding.FragmentMangaBinding
import com.example.kitsuapi.ui.adapters.MangaAdapter
import com.example.kitsuapi.ui.fragments.tablayout.TabLayoutFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MangaFragment:
    BaseFragment<MangaViewModel, FragmentMangaBinding>(R.layout.fragment_manga) {

    override val binding by viewBinding(FragmentMangaBinding::bind)
    override val viewModel by viewModels<MangaViewModel>()
    private var mangaAdapter = MangaAdapter(this::onItemClick)

    override fun initialise() {
        binding.rvManga.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = mangaAdapter
        }
    }

    override fun setupSubscribers() {
        subscribeToFetchManga()
    }

    private fun subscribeToFetchManga() {
        lifecycleScope.launch {
            viewModel.fetchManga().collect{
                mangaAdapter.submitData(it)
            }
        }
    }

    private fun onItemClick(id: String) {
        findNavController().navigate(TabLayoutFragmentDirections.actionTabLayoutFragmentToDetailMangaFragment(id))
    }
}