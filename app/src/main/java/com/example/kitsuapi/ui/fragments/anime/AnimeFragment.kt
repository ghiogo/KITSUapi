package com.example.kitsuapi.ui.fragments.anime

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapi.R
import com.example.kitsuapi.base.BaseFragment
import com.example.kitsuapi.databinding.FragmentAnimeBinding
import com.example.kitsuapi.ui.adapters.AnimeAdapter
import com.example.kitsuapi.ui.fragments.tablayout.TabLayoutFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment :
    BaseFragment<AnimeViewModel, FragmentAnimeBinding>(R.layout.fragment_anime) {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel : AnimeViewModel by viewModels()
    private var animeAdapter = AnimeAdapter(this::onItemClick)

    override fun initialise() {
        binding.rvAnime.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = animeAdapter
        }
    }

    override fun setupSubscribers() {
        subscribeToFetchAnime()
    }

    private fun subscribeToFetchAnime() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fetchAnime().collect{
                animeAdapter.submitData(it)
                Toast.makeText(requireContext(), "fragment Anime", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun onItemClick(id: String) {
        findNavController().navigate(TabLayoutFragmentDirections.actionTabLayoutFragmentToDetailAnimeFragment(
            id))
    }
}
