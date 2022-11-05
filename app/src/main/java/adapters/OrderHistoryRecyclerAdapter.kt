package adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import classes.OrderHistory
import com.example.fooddeliveryproject.R
import fragment.user.OrderHistoryFragment

class OrderHistoryRecyclerAdapter(val context : OrderHistoryFragment, val orderHistoryList : List<OrderHistory>)
    : RecyclerView.Adapter<OrderHistoryRecyclerAdapter.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerlayout_orderhistory, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val order = orderHistoryList[position]

        holder.restaurantView.text = orderHistoryList[position].restaurantName
        // Kan behöva ändra pga att order är en lista
        holder.orderView.text = orderHistoryList[position].order
        holder.dateView.text = orderHistoryList[position].dateOfPurchase
    }

    override fun getItemCount(): Int {
        return orderHistoryList.size
    }





    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val restaurantView = itemView.findViewById<TextView>(R.id.orderHistory_restaurant)
        val orderView = itemView.findViewById<TextView>(R.id.orderHistory_order)
        val dateView = itemView.findViewById<TextView>(R.id.orderHistory_date)



    }



}