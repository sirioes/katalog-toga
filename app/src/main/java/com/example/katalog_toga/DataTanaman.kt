package com.example.katalog_toga

object DataTanaman {
    fun getAll(): MutableList<Tanaman> = mutableListOf(
        Tanaman(
            nama = "Jahe",
            namaLatin = "Zingiber officinale",
            emoji = "🫚",
            kategori = "Rimpang",
            asal = "Asia Selatan & Tenggara",
            manfaat = "Meredakan mual, menghangatkan tubuh, melancarkan peredaran darah, anti-inflamasi, meningkatkan daya tahan tubuh.",
            bagian = "Rimpang (akar)",
            caraPenggunaan = "Iris tipis lalu rebus dengan 2 gelas air hingga tersisa 1 gelas. Minum selagi hangat, 2x sehari.",
            peringatan = "Hindari konsumsi berlebihan jika memiliki maag atau asam lambung tinggi."
        ),
        Tanaman(
            nama = "Kunyit",
            namaLatin = "Curcuma longa",
            emoji = "🟡",
            kategori = "Rimpang",
            asal = "Asia Selatan (India)",
            manfaat = "Anti-inflamasi, antioksidan, melancarkan pencernaan, meredakan nyeri haid, menjaga kesehatan liver.",
            bagian = "Rimpang (akar)",
            caraPenggunaan = "Parut rimpang kunyit, peras airnya, campur dengan madu dan air hangat. Minum 1x sehari.",
            peringatan = "Tidak dianjurkan untuk ibu hamil dalam dosis tinggi. Dapat mewarnai gigi jika dikonsumsi berlebihan."
        ),
        Tanaman(
            nama = "Kencur",
            namaLatin = "Kaempferia galanga",
            emoji = "🌾",
            kategori = "Rimpang",
            asal = "Asia Tenggara",
            manfaat = "Meredakan batuk, menghangatkan tubuh, menambah nafsu makan, membantu pemulihan kelelahan, anti-inflamasi.",
            bagian = "Rimpang (akar)",
            caraPenggunaan = "Parut rimpang kencur segar, campur dengan sedikit garam dan air hangat. Minum atau oleskan pada dada untuk batuk.",
            peringatan = "Hindari konsumsi berlebihan karena dapat menyebabkan iritasi lambung pada sebagian orang."
        ),
        Tanaman(
            nama = "Lidah Buaya",
            namaLatin = "Aloe vera",
            emoji = "🌵",
            kategori = "Sukulen",
            asal = "Semenanjung Arab",
            manfaat = "Melembapkan kulit, meredakan luka bakar ringan, melancarkan pencernaan, mengobati sariawan.",
            bagian = "Gel dari daun",
            caraPenggunaan = "Untuk kulit: oleskan gel langsung ke area yang terkena. Untuk diminum: ambil gel, cuci bersih, konsumsi 1 sdm/hari.",
            peringatan = "Getah berwarna kuning (aloin) bersifat laksatif, hindari dikonsumsi berlebihan. Uji alergi sebelum dioleskan."
        ),
        Tanaman(
            nama = "Serai",
            namaLatin = "Cymbopogon citratus",
            emoji = "🌿",
            kategori = "Herbal",
            asal = "Asia Selatan",
            manfaat = "Meredakan nyeri, antijamur, menurunkan demam, melancarkan pencernaan, mengurangi kecemasan.",
            bagian = "Batang dan daun",
            caraPenggunaan = "Rebus 2–3 batang serai yang dimemarkan dengan 2 gelas air. Minum selagi hangat 2x sehari.",
            peringatan = "Beberapa orang mungkin mengalami alergi kulit. Ibu hamil sebaiknya berkonsultasi sebelum mengonsumsi."
        ),
        Tanaman(
            nama = "Kumis Kucing",
            namaLatin = "Orthosiphon aristatus",
            emoji = "🌺",
            kategori = "Herbal",
            asal = "Asia Tenggara",
            manfaat = "Melancarkan buang air kecil, mengobati infeksi saluran kemih, mencegah batu ginjal, menurunkan tekanan darah.",
            bagian = "Daun dan bunga",
            caraPenggunaan = "Rebus 30–50 lembar daun segar dengan 3 gelas air hingga tersisa 2 gelas. Minum 2x sehari.",
            peringatan = "Jangan konsumsi berlebihan karena efek diuretik kuat. Konsultasikan ke dokter jika ada masalah ginjal serius."
        ),
        Tanaman(
            nama = "Temulawak",
            namaLatin = "Curcuma xanthorrhiza",
            emoji = "🫛",
            kategori = "Rimpang",
            asal = "Indonesia (Jawa)",
            manfaat = "Meningkatkan nafsu makan, menjaga kesehatan hati, anti-inflamasi, membantu pemulihan setelah sakit.",
            bagian = "Rimpang (akar)",
            caraPenggunaan = "Rebus 2–3 iris rimpang temulawak dengan 2 gelas air hingga tersisa 1 gelas. Minum 2x sehari.",
            peringatan = "Konsultasikan ke dokter jika memiliki gangguan empedu atau sedang mengonsumsi obat pengencer darah."
        ),
        Tanaman(
            nama = "Kayu Manis",
            namaLatin = "Cinnamomum verum",
            emoji = "🪵",
            kategori = "Kulit Kayu",
            asal = "Sri Lanka",
            manfaat = "Mengontrol gula darah, antioksidan kuat, antibakteri, menghangatkan tubuh, membantu pencernaan.",
            bagian = "Kulit batang (kayu)",
            caraPenggunaan = "Rebus 1 batang kayu manis dengan 2 gelas air selama 10 menit. Minum 1x sehari, bisa ditambah madu.",
            peringatan = "Hindari konsumsi berlebihan karena mengandung kumarin yang dapat merusak hati. Tidak untuk ibu hamil dalam dosis tinggi."
        ),
        Tanaman(
            nama = "Daun Sirih",
            namaLatin = "Piper betle",
            emoji = "🍃",
            kategori = "Daun",
            asal = "Asia Tenggara",
            manfaat = "Antiseptik, mengobati keputihan, meredakan batuk, menyegarkan mulut, membantu penyembuhan luka.",
            bagian = "Daun",
            caraPenggunaan = "Rebus 5–10 lembar daun sirih dengan 2 gelas air, gunakan air rebusan untuk berkumur atau membasuh area yang terinfeksi.",
            peringatan = "Penggunaan jangka panjang dapat mengiritasi mukosa mulut. Jangan menelan air rebusan dalam jumlah besar."
        ),
        Tanaman(
            nama = "Kapulaga",
            namaLatin = "Elettaria cardamomum",
            emoji = "🌱",
            kategori = "Rempah",
            asal = "India Selatan",
            manfaat = "Menyegarkan napas, melancarkan pencernaan, meredakan kembung, membantu mengatasi insomnia, antioksidan.",
            bagian = "Biji dan polong",
            caraPenggunaan = "Geprek 3–5 biji kapulaga, rebus dengan 2 gelas air selama 10 menit. Minum hangat 1–2x sehari.",
            peringatan = "Konsumsi berlebihan dapat menyebabkan efek laksatif ringan. Hindari jika alergi terhadap rempah famili Zingiberaceae."
        ),
        Tanaman(
            nama = "Biji Pala",
            namaLatin = "Myristica fragrans",
            emoji = "🟤",
            kategori = "Rempah",
            asal = "Kepulauan Banda, Maluku",
            manfaat = "Membantu mengatasi insomnia, meredakan nyeri, anti-inflamasi, melancarkan pencernaan, antibakteri.",
            bagian = "Biji",
            caraPenggunaan = "Parut sedikit biji pala (1/4 sdt) dan campurkan ke susu hangat atau madu. Minum sebelum tidur.",
            peringatan = "BERBAHAYA dalam dosis tinggi (>5 gram) — dapat menyebabkan halusinasi dan keracunan. Gunakan hanya dalam jumlah kecil."
        ),
        Tanaman(
            nama = "Sambiloto",
            namaLatin = "Andrographis paniculata",
            emoji = "🌿",
            kategori = "Herbal",
            asal = "Asia Selatan & Tenggara",
            manfaat = "Menurunkan demam, anti-bakteri, meningkatkan imunitas, membantu mengobati infeksi saluran pernapasan.",
            bagian = "Daun dan batang",
            caraPenggunaan = "Rebus 10–15 lembar daun segar dengan 3 gelas air hingga tersisa 2 gelas. Minum 2x sehari setelah makan.",
            peringatan = "Rasa sangat pahit. Tidak dianjurkan untuk ibu hamil dan menyusui. Batasi konsumsi jangka panjang."
        ),
        Tanaman(
            nama = "Seledri",
            namaLatin = "Apium graveolens",
            emoji = "🥬",
            kategori = "Sayuran",
            asal = "Mediterania",
            manfaat = "Menurunkan tekanan darah tinggi, diuretik alami, antioksidan, menjaga kesehatan jantung, mengurangi peradangan.",
            bagian = "Daun, batang, dan biji",
            caraPenggunaan = "Jus 3–4 tangkai seledri segar setiap pagi, atau rebus daun seledri dengan 2 gelas air dan minum 1x sehari.",
            peringatan = "Hindari konsumsi berlebihan jika sedang mengonsumsi obat pengencer darah. Dapat memicu alergi pada sebagian orang."
        ),
        Tanaman(
            nama = "Kelor",
            namaLatin = "Moringa oleifera",
            emoji = "🌳",
            kategori = "Daun",
            asal = "Asia Selatan (India, Pakistan)",
            manfaat = "Supergizi tinggi (vitamin & mineral), anti-inflamasi, menurunkan gula darah, meningkatkan ASI, antioksidan kuat.",
            bagian = "Daun, biji, dan kulit batang",
            caraPenggunaan = "Konsumsi daun kelor sebagai sayur bening atau urap. Bisa juga dikeringkan dan diseduh seperti teh, 1–2x sehari.",
            peringatan = "Akar dan kulit batang dapat bersifat toksik dalam jumlah besar. Ibu hamil hindari konsumsi akar kelor."
        ),
        Tanaman(
            nama = "Belimbing Wuluh",
            namaLatin = "Averrhoa bilimbi",
            emoji = "💚",
            kategori = "Buah",
            asal = "Indonesia & Malaysia",
            manfaat = "Menurunkan tekanan darah, mengobati batuk, mengatasi jerawat, antibakteri, melancarkan pencernaan.",
            bagian = "Buah dan daun",
            caraPenggunaan = "Rebus 10–15 buah belimbing wuluh dengan 3 gelas air dan sedikit garam hingga tersisa 2 gelas. Minum 2x sehari.",
            peringatan = "Kandungan asam oksalat tinggi — berbahaya bagi penderita gagal ginjal. Hindari konsumsi berlebihan."
        )
    )
}
