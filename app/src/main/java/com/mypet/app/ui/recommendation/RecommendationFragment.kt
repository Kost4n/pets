package com.mypet.app.ui.recommendation

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mypet.app.databinding.FragmentRecommendationBinding

class RecommendationFragment : Fragment() {

    private var _binding: FragmentRecommendationBinding? = null
    private val binding get() = _binding!!

    private val htmlText = "Certainly, here's a basic guide on pet care in English:\n" +
            "\n" +
            "Pet Care: Care Guide\n" +
            "\n" +
            "1. Feeding:\n" +
            "   - Feed your pet regularly, following the recommended quantity and type of food indicated on the packaging or advised by a veterinarian.\n" +
            "   - Ensure that your pet always has access to fresh water.\n" +
            "   - Monitor calories and your pet's weight to prevent overeating or underfeeding.\n" +
            "\n" +
            "2. Healthcare:\n" +
            "   - Regularly take your pet to the veterinarian for check-ups and vaccinations.\n" +
            "   - Pay attention to dental health and hygiene.\n" +
            "   - Protect your pet from fleas and ticks and use appropriate parasite control measures when necessary.\n" +
            "\n" +
            "3. Grooming:\n" +
            "   - Regularly clean and brush your pet's fur, especially for breeds that require special grooming.\n" +
            "   - Bathe your pet when necessary, using pet-specific shampoos.\n" +
            "   - Trim your pet's nails to prevent overgrowth.\n" +
            "\n" +
            "4. Physical Activity:\n" +
            "   - Provide your pet with sufficient physical activity and playtime.\n" +
            "   - Take dogs for walks in the fresh air and engage cats in play with toys.\n" +
            "   - Offer a designated area for your pet to exercise and play.\n" +
            "\n" +
            "5. Cage or Habitat Care:\n" +
            "   - Regularly clean your pet's enclosure or habitat.\n" +
            "   - Ensure warmth, comfort, and safety in the living space of your pet.\n" +
            "\n" +
            "6. Socialization and Training:\n" +
            "   - Socialize your pet with other animals and people.\n" +
            "   - Train your pet with commands and behavior guidelines.\n" +
            "\n" +
            "7. Love and Attention:\n" +
            "   - Shower your pet with love and attention.\n" +
            "   - Spend quality time playing and interacting to maintain your pet's emotional well-being.\n" +
            "\n" +
            "8. Safety:\n" +
            "   - Ensure your pet's safety by keeping them away from items and substances that could harm them.\n" +
            "   - Keep control of your pet when outside by using a leash or collar.\n" +
            "\n" +
            "These are general guidelines for pet care. Keep in mind that different types of pets may require care and attention in different ways. Always consult with a veterinarian and learn about the specific care needs of your particular type of pet."

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRecommendationBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.view.text = htmlText
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
