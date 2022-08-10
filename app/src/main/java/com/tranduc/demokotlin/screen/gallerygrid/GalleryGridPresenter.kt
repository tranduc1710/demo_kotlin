package com.tranduc.demokotlin.screen.gallerygrid

import android.os.Build
import androidx.annotation.RequiresApi
import com.tranduc.demokotlin.model.Gallery
import com.tranduc.demokotlin.model.ImageGallery
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class GalleryGridPresenter {
    var lImage: MutableList<ImageGallery> = mutableListOf()
    var lImageSort: MutableList<Gallery> = mutableListOf()

    @RequiresApi(Build.VERSION_CODES.O)
    fun getList() {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val dt = LocalDate.parse("12/03/2021", formatter)
        val dt2 = LocalDate.parse("15/03/2021", formatter)
        val dt3 = LocalDate.parse("12/07/2021", formatter)

        lImage.addAll(
            mutableListOf(
//                ImageGallery("https://i.pinimg.com/564x/12/99/40/129940277d89469c3e883567442f553a.jpg", dt),
//                ImageGallery("https://i.pinimg.com/474x/6c/bd/03/6cbd037d36a05f7c6db639b19f9b48a7.jpg", dt),
//                ImageGallery("https://i.pinimg.com/474x/7c/34/f8/7c34f8d96c4e7105915a4856cbab31be.jpg", dt),
//                ImageGallery("https://i.pinimg.com/474x/4d/d2/18/4dd2186abddb55d6c4f3646f4dac5cd0.jpg", dt),
//                ImageGallery("https://i.pinimg.com/474x/c8/80/71/c88071a3a5624aa7f6f0188f81f8246d.jpg", dt),
//                ImageGallery("https://i.pinimg.com/474x/fa/82/2a/fa822a8b6fec954d4e82e8f77aa34f49.jpg", dt2),
//                ImageGallery("https://i.pinimg.com/474x/db/af/6d/dbaf6d80d6c0acf6af030cddd988d450.jpg", dt2),
//                ImageGallery("https://i.pinimg.com/474x/b8/88/6d/b8886dca2122cfdf146d0060e277ab49.jpg", dt2),
//                ImageGallery("https://i.pinimg.com/474x/d4/b3/05/d4b305c27c1672f7085fa650f8493a6c.jpg", dt2),
//                ImageGallery("https://i.pinimg.com/474x/3c/64/9d/3c649d076705c4b81b6498f830da78ce.jpg", dt3),
//                ImageGallery("https://i.pinimg.com/474x/b4/2b/56/b42b56f98568aae994dec4942829aca1.jpg", dt3),
//                ImageGallery("https://i.pinimg.com/474x/f2/0b/b7/f20bb778886d953ab0e172ca854a13d0.jpg", dt3),
//                ImageGallery("https://i.pinimg.com/474x/80/b8/08/80b808926cfa654f66df5ddcc6af9e46.jpg", dt3),
//                ImageGallery("https://i.pinimg.com/474x/51/fc/0b/51fc0b7037376a603e92fdc43686a9c5.jpg", dt3),
//                ImageGallery("https://i.pinimg.com/474x/41/06/2e/41062e9149a4bbc011f1c4e37efbc29f.jpg", dt3),
//                ImageGallery("https://i.pinimg.com/474x/f1/49/d6/f149d6b9c2c2a87b6cbf1ad4cbc45166.jpg", dt3),
                ImageGallery("https://img.freepik.com/premium-photo/newborn-toddler-boy-laughing-bed_115594-1502.jpg", dt),
                ImageGallery("https://i.pinimg.com/474x/6c/bd/03/6cbd037d36a05f7c6db639b19f9b48a7.jpg", dt),
                ImageGallery("https://i.pinimg.com/474x/7c/34/f8/7c34f8d96c4e7105915a4856cbab31be.jpg", dt),
                ImageGallery("https://i.pinimg.com/474x/4d/d2/18/4dd2186abddb55d6c4f3646f4dac5cd0.jpg", dt),
                ImageGallery("https://i.pinimg.com/474x/c8/80/71/c88071a3a5624aa7f6f0188f81f8246d.jpg", dt2),
                ImageGallery("https://i.pinimg.com/474x/fa/82/2a/fa822a8b6fec954d4e82e8f77aa34f49.jpg", dt3),
                ImageGallery("https://i.pinimg.com/474x/db/af/6d/dbaf6d80d6c0acf6af030cddd988d450.jpg", dt),
                ImageGallery("https://i.pinimg.com/474x/b8/88/6d/b8886dca2122cfdf146d0060e277ab49.jpg", dt2),
                ImageGallery("https://i.pinimg.com/474x/d4/b3/05/d4b305c27c1672f7085fa650f8493a6c.jpg", dt2),
                ImageGallery("https://i.pinimg.com/474x/3c/64/9d/3c649d076705c4b81b6498f830da78ce.jpg", dt3),
                ImageGallery("https://i.pinimg.com/474x/b4/2b/56/b42b56f98568aae994dec4942829aca1.jpg", dt2),
                ImageGallery("https://i.pinimg.com/474x/f2/0b/b7/f20bb778886d953ab0e172ca854a13d0.jpg", dt2),
                ImageGallery("https://i.pinimg.com/474x/80/b8/08/80b808926cfa654f66df5ddcc6af9e46.jpg", dt3),
                ImageGallery("https://i.pinimg.com/474x/51/fc/0b/51fc0b7037376a603e92fdc43686a9c5.jpg", dt3),
                ImageGallery("https://i.pinimg.com/474x/41/06/2e/41062e9149a4bbc011f1c4e37efbc29f.jpg", dt3),
                ImageGallery("https://i.pinimg.com/474x/f1/49/d6/f149d6b9c2c2a87b6cbf1ad4cbc45166.jpg", dt3),
            )
        )

        for (index in 0 until lImage.size){
            if (index == 0){
                lImageSort.add(Gallery(lImage[index].dateTime, mutableListOf(lImage[index])))
                continue
            }
            val indexItem = lImageSort.indexOfFirst { gallery -> gallery.date.isEqual(lImage[index].dateTime) }

            if(lImage[index].dateTime.isAfter(lImage[index-1].dateTime) && indexItem == -1){
                lImageSort.add(Gallery(lImage[index].dateTime, mutableListOf(lImage[index])))
            }else{
                lImageSort[indexItem].lImage.add(lImage[index])
            }
        }
    }
}
