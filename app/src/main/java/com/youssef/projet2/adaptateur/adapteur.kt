package com.youssef.projet2.adaptateur

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.youssef.projet2.R
import com.youssef.projet2.classess.categorie

/**
 * Created by user on 07/04/2018.
 */
class adapteur(contexte : Context, categori : List<categorie> ) : BaseAdapter() {
    val contextes = contexte
    val categories = categori

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
    val categorieAparence : View

        var Categorie : categoriea
        Categorie = categoriea()

        if (convertView ==null) {
            categorieAparence = LayoutInflater.from(contextes).inflate(R.layout.categoriearray, null)
            Categorie.categorieimage= categorieAparence.findViewById(R.id.imagecategorie)
            Categorie.categorietext= categorieAparence.findViewById(R.id.Textcategorie)
            categorieAparence.tag =Categorie
        println("Oui")
        }
        else
        {
             Categorie = convertView.tag as categoriea
            categorieAparence = convertView
            println("non")
        }

     val category = categories[position]
        Categorie.categorietext?.text=   category.titre
     val ressourceid = contextes.resources.getIdentifier(category.image,"drawable",contextes.packageName)
        Categorie.categorieimage?.setImageResource(ressourceid)

        return categorieAparence
    }

    override fun getItem(position: Int): Any {
    return  categories[position]
     }

    override fun getItemId(position: Int): Long {
return 0    }

    override fun getCount(): Int {
       return categories.count()
    }

   private class categoriea ()
   {
       var categorieimage :ImageView?=null
       var categorietext : TextView?=null
   }

}