package adapters.restaurantMenuAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import classes.OrderItem
import classes.ShoppingCart
import com.example.fooddeliveryproject.R
import fragment.restaurantMenu.OlearysMenuFragment

class OlearysMenuRecyclerAdapter (val context: OlearysMenuFragment, val orderItems: List<OrderItem>) :
    RecyclerView.Adapter<OlearysMenuRecyclerAdapter.ViewHolder>() {


    //onClickListener setup
    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.restaurant_menu_list_item, parent, false)
        return ViewHolder(itemView, mListener)


    }//End of clickListener


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Takes the right restaurant from the list
        val orderItem = orderItems[position]
//        val orderRestaurantName = orderItem.restaurantName
//        val orderDeliveryFee = orderItem.deliveryFee
        //Assigns the right information to the restaurant
        holder.orderItemNameView.text = orderItem.orderFromMeny
        holder.orderItemNPriceView.text = "${orderItem.price} kr"

        holder.orderRestaurantName = orderItem.restaurantName
        holder.orderDeliveryFee = orderItem.deliveryFee
        holder.orderItemPrice = orderItem.price
        holder.orderItemName = orderItem.orderFromMeny




//        //Glide for image
//        Glide.with(context)
//            .load(restaurant.image)
//            .into(holder.restaurantHeaderImageView)

    }

    //counts how many restaurants there are in the list
    override fun getItemCount(): Int {
        return orderItems.size
    }


    inner class ViewHolder(itemView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        //When a viewHolder is created, it finds the ImageView and textViews in our itemView
        var orderItemNameView = itemView.findViewById<TextView>(R.id.orderItemNameView)
        var orderItemNPriceView = itemView.findViewById<TextView>(R.id.orderItemPriceView)

        var orderRestaurantName = ""
        var orderDeliveryFee = 0
        var orderItemPrice = 0
        var orderItemName = ""

        var orderButton = itemView.findViewById<Button>(R.id.addToOrderButton).setOnClickListener{
            val orderRestaurant = orderRestaurantName
            val orderMenuItem = orderItemName
            val orderPrice = orderItemPrice
            val deliveryFee = orderDeliveryFee
            val newOrder = OrderItem(orderRestaurant, orderMenuItem, orderPrice, deliveryFee)
            ShoppingCart.addItemToCart(newOrder)
        }

        //init of the clicklistener that checks position
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)

            }
        }



    }

}