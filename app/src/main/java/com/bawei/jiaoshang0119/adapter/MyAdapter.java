package com.bawei.jiaoshang0119.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.bawei.jiaoshang0119.R;
import com.bawei.jiaoshang0119.activity.XiangQingActivity;
import com.bawei.jiaoshang0119.bean.Bean;
import com.bawei.jiaoshang0119.bean.EventBean;
import com.bawei.jiaoshang0119.retrofit.OnItemClickListener;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adminjs on 2017/12/21.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.IViewholder>{
    private Context context;
    private List<Bean.TuijianBean.ListBean> list;
    public MyAdapter(Context context) {
        this.context = context;
    }
    public void addData(Bean bean){
        if(list == null){
            list = new ArrayList<>();
        }
        if (bean.getData() == null){
            Toast.makeText(context, "不能为空", Toast.LENGTH_SHORT).show();
        }else{
            list.addAll(bean.getTuijian().getList());

        }
        notifyDataSetChanged();

    }
    @Override
    public IViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_layout, null);
        return new IViewholder(view);
    }

    @Override
    public void onBindViewHolder(final IViewholder holder, final int position) {
       String[] url = list.get(position).getImages().split("\\|");
        holder.simpleDraweeView.setImageURI(url[0],list.get(position).getImages());
        holder.title.setText(list.get(position).getTitle());
        holder.price.setText(list.get(position).getBargainPrice()+"");
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
        roundingParams.setRoundAsCircle(true);
        holder.simpleDraweeView.getHierarchy().setRoundingParams(roundingParams);
        if(mOnItemClickListener != null){
            //为ItemView设置监听器
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView,position);
                    EventBus.getDefault().postSticky(new EventBean(list.get(position).getPid()+"",list.get(position).getImages(),list.get(position).getTitle(),list.get(position).getPrice()+""));

                    Intent intent = new Intent(context, XiangQingActivity.class);
//                    Bundle bundle = new Bundle();
//                    bundle.putString("pid",list.get(position).getPid()+"");
//                    bundle.putString("image", list.get(position).getImages());
//                    bundle.putString("name",list.get(position).getTitle());
//                    bundle.putString("price",list.get(position).getPrice()+"");
//                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    private OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    class IViewholder extends RecyclerView.ViewHolder{

        SimpleDraweeView simpleDraweeView;
        TextView title;
        TextView price;
        public IViewholder(View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.simple);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
        }
    }
}
