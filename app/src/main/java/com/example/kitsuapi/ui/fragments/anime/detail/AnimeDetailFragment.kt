package com.example.kitsuapi.ui.fragments.anime.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapi.R
import com.example.kitsuapi.base.BaseFragment
import com.example.kitsuapi.extensions.setImage
import com.example.kitsuapi.databinding.FragmentAnimeDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailFragment : BaseFragment<AnimeDetailViewModel, FragmentAnimeDetailBinding>
    (R.layout.fragment_anime_detail) {

    override val binding by viewBinding(FragmentAnimeDetailBinding::bind)
    override val viewModel: AnimeDetailViewModel by viewModels()
    private val args: AnimeDetailFragmentArgs by navArgs()

    override fun setupSubscribers() {
        viewModel.fetchDetailAnime(args.id).subscribe(
            onError = {},
            onSuccess = { it ->
                it.data.let {
                    binding.animeName.text = it.attributes.titles.enJp
                    binding.animeImageView.setImage(it.attributes.posterImage.original)
                    binding.backgroundImg.setImage(it.attributes.posterImage.large)
                    binding.tvAnimeStudios.text = it.attributes.slug
                    binding.tvAnimeEpisodes.text = it.attributes.episodeCount.toString()
                    binding.tvAnimeStatus.text = it.attributes.status
                    binding.tvAnimePremiered.text = it.attributes.createdAt
                    binding.tvAnimeAgeRating.text = it.attributes.ageRating
                }
            }
        )
    }
}
