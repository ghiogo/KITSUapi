package com.example.kitsuapi.ui.fragments.manga.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapi.R
import com.example.kitsuapi.base.BaseFragment
import com.example.kitsuapi.extensions.setImage
import com.example.kitsuapi.databinding.FragmentMangaDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaDetailFragment : BaseFragment<MangaDetailViewModel, FragmentMangaDetailBinding>
    (R.layout.fragment_manga_detail) {

    override val binding by viewBinding(FragmentMangaDetailBinding::bind)
    override val viewModel: MangaDetailViewModel by viewModels()
    private val args: MangaDetailFragmentArgs by navArgs()

    override fun setupSubscribers() {
        viewModel.fetchDetailManga(args.id).subscribe(
            onError = {},
            onSuccess = { it ->
                it.data.let {
                    binding.mangaName.text = it.attributes.titles.enJp
                    binding.mangaImageView.setImage(it.attributes.posterImage.original)
                    binding.backgroundImg.setImage(it.attributes.posterImage.large)
                    binding.itemMangaChapters.text =
                        it.attributes.chapterCount.toString()
                    binding.itemMangaStatus.text = it.attributes.status
                    binding.itemMangaPremiered.text = it.attributes.createdAt
                    binding.itemMangaAgeRating.text = it.attributes.ageRating
                }
            }
        )
    }
}
