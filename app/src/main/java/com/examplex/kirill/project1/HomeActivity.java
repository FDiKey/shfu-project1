package com.examplex.kirill.project1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.examplex.kirill.project1.adapters.MyRecyclerAdapter;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ListView list;
    private static List<Hacker> list1 = new ArrayList<Hacker>();
    public RecyclerView rv;
    private Paint p = new Paint();
    ItemTouchHelper itemTouchHelper;
    public MyRecyclerAdapter adpter;
    ItemTouchHelper.SimpleCallback simpleItemTouchCallback;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initData();
        initRecycler();

    }

    private void initRecycler() {

        rv = (RecyclerView) findViewById(R.id.recycler);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        rv.hasFixedSize();
        adpter = new MyRecyclerAdapter(list1, this);

//        ItemTouchHelper.SimpleCallback touch = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
//            @Override
//            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
//
//                return false;
//            }
//
//            @Override
//            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
//                adpter.list.remove(viewHolder.getItemId());
//                Toast.makeText(HomeActivity.this, "", Toast.LENGTH_SHORT).show();
//            }
//        };
//
//        itemTouchHelper = new ItemTouchHelper(touch);
//        itemTouchHelper.attachToRecyclerView(rv);
        rv.setAdapter(adpter);
        enableSwipe();

    }




    private void initData(){
        list1.add(new Hacker("Zero Cool", R.drawable.zerocool));
        list1.add(new Hacker("Acid Burn", R.drawable.acidburn));
        list1.add(new Hacker("Cereal  Killer", R.drawable.cereal));
        list1.add(new Hacker("Lord Nikon", R.drawable.nickon));
        list1.add(new Hacker("Phantom Phreak", R.drawable.cookies));
        list1.add(new Hacker("Razor", R.drawable.razor));
        list1.add(new Hacker("Blade", R.drawable.blade));
        list1.add(new Hacker("UltraLazor", R.drawable.killer));
        list1.add(new Hacker("Dr. Doom", R.drawable.doom));
        list1.add(new Hacker("Crash Override", R.drawable.crash));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);


        Drawer.Result drawer =  new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withDisplayBelowToolbar(true)
                .withActionBarDrawerToggle(true)
                .addDrawerItems( new PrimaryDrawerItem()
                        .withName(R.string.d_List)
                        .withIdentifier(1),
                        new PrimaryDrawerItem()
                                .withName(R.string.d_add)
                                .withIdentifier(2),
                        new PrimaryDrawerItem()
                                .withName(R.string.d_profile)
                                .withIdentifier(3)

                        )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                        switch(drawerItem.getIdentifier())
                        {
                            case 1:{

                                break;
                            }
                            case 2:{
                                intent = new Intent(HomeActivity.this, EditItem.class);
                                startActivityForResult(intent,1);

                                break;
                            }
                            case 3:{

                                break;
                            }
                        }
                    }
                })
                .build();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {return;}
        String name = data.getStringExtra("res_name");
        list1.add(new Hacker(name, R.drawable.crash));
        adpter.notifyDataSetChanged();
    }


        private void enableSwipe () {
            simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

                @Override
                public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                    return false;
                }

                @Override
                public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                    int position = viewHolder.getAdapterPosition();

                    if (direction == ItemTouchHelper.LEFT){
                        final Hacker deletedModel = list1.get(position);
                        final int deletedPosition = position;
                        adpter.removeItem(position);
                        // showing snack bar with Undo option
                        Snackbar snackbar = Snackbar.make(getWindow().getDecorView().getRootView(), " removed from Recyclerview!", Snackbar.LENGTH_LONG);
                        snackbar.setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                // undo is selected, restore the deleted item
                                adpter.restoreItem(deletedModel, deletedPosition);
                            }
                        });
                        snackbar.setActionTextColor(Color.YELLOW);
                        snackbar.show();
                    } else {
                        final Hacker deletedModel = list1.get(position);
                        final int deletedPosition = position;
                        adpter.removeItem(position);
                        // showing snack bar with Undo option
                        Snackbar snackbar = Snackbar.make(getWindow().getDecorView().getRootView(), " removed from Recyclerview!", Snackbar.LENGTH_LONG);
                        snackbar.setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                // undo is selected, restore the deleted item
                                adpter.restoreItem(deletedModel, deletedPosition);
                            }
                        });
                        snackbar.setActionTextColor(Color.YELLOW);
                        snackbar.show();
                    }
                }

                @Override
                public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

                    Bitmap icon;
                    if(actionState == ItemTouchHelper.ACTION_STATE_SWIPE){

                        View itemView = viewHolder.itemView;
                        float height = (float) itemView.getBottom() - (float) itemView.getTop();
                        float width = height / 3;

                        if(dX > 0){
                            p.setColor(Color.parseColor("#388E3C"));
                            RectF background = new RectF((float) itemView.getLeft(), (float) itemView.getTop(), dX,(float) itemView.getBottom());
                            c.drawRect(background,p);
                            icon = BitmapFactory.decodeResource(getResources(), R.drawable.razor);
                            RectF icon_dest = new RectF((float) itemView.getLeft() + width ,(float) itemView.getTop() + width,(float) itemView.getLeft()+ 2*width,(float)itemView.getBottom() - width);
                            c.drawBitmap(icon,null,icon_dest,p);
                        } else {
                            p.setColor(Color.parseColor("#D32F2F"));
                            RectF background = new RectF((float) itemView.getRight() + dX, (float) itemView.getTop(),(float) itemView.getRight(), (float) itemView.getBottom());
                            c.drawRect(background,p);
                            icon = BitmapFactory.decodeResource(getResources(), R.drawable.razor);
                            RectF icon_dest = new RectF((float) itemView.getRight() - 2*width ,(float) itemView.getTop() + width,(float) itemView.getRight() - width,(float)itemView.getBottom() - width);
                            c.drawBitmap(icon,null,icon_dest,p);
                        }
                    }
                    super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
                }
            };
            ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
            itemTouchHelper.attachToRecyclerView(rv);
        }
}


