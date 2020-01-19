package com.example.bogdan.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RideAdapter extends RecyclerView.Adapter<RideAdapter.RideHolder> {


    public List<Ride> rides = new ArrayList<>();
    private BookingViewModel bookingViewModel;
    private int userId;

    /*public RideAdapter(List<Ride> rides){
        this.rides=rides;
    }

     */

    public RideAdapter(BookingViewModel bookingViewModel,int userId){
        this.bookingViewModel=bookingViewModel;
        this.userId=userId;

    }



    @NonNull
    @Override
    public RideHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {




        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.ride_item,viewGroup,false);

        return new RideHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull RideHolder rideHolder, int i) {

        final Ride currentRide = rides.get(i);
        Log.d(".RideAdapter",currentRide.getFrom());

        rideHolder.textViewName.setText("Nume");
        rideHolder.textViewFrom.setText(currentRide.getFrom());
        rideHolder.textViewTo.setText(currentRide.getTo());
        rideHolder.textViewDate.setText(currentRide.getDate());
        rideHolder.textViewHour.setText(currentRide.getHour());
        rideHolder.textViewPrice.setText(currentRide.getPrice());
        rideHolder.availableSeats.setText(currentRide.getSeatsNumber());

        rideHolder.button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                        builder.setTitle("Title");

// Set up the input
                        final EditText input = new EditText(view.getContext());
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        builder.setView(input);

// Set up the buttons
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Booking booking=new Booking();
                                booking.setId_user(userId);
                                booking.setId_ride(currentRide.getId());
                                booking.setSeatNumber(Integer.valueOf(input.getText().toString()));
                                bookingViewModel.makeBooking(booking);
                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                        builder.show();

                    }
                }
        );




    }

    @Override
    public int getItemCount() {
        return rides.size();
    }

    public Ride getTideAt(int position){
        return rides.get(position);
    }


    public void setRides(List<Ride> rides){
        this.rides.addAll(rides);
        for(Ride ride:this.rides){
            Log.d(".RideAdapter",ride.getFrom());
        }
        notifyDataSetChanged();
    }


    class RideHolder extends RecyclerView.ViewHolder{

        private TextView textViewName;
        private TextView textViewFrom;
        private TextView textViewTo;
        private TextView textViewDate;
        private TextView textViewHour;
        private TextView textViewPrice;
        private TextView availableSeats;
        private ImageButton button;


        public RideHolder(@NonNull View itemView) {
            super(itemView);


            textViewName = itemView.findViewById(R.id.ride_name);
            textViewFrom= itemView.findViewById(R.id.ride_from);
            textViewTo = itemView.findViewById(R.id.ride_to);
            textViewDate = itemView.findViewById(R.id.ride_date);
            textViewHour = itemView.findViewById(R.id.ride_hour);
            textViewPrice = itemView.findViewById(R.id.ride_price);
            availableSeats=itemView.findViewById(R.id.seats_number);
            button=itemView.findViewById(R.id.button_mesg);

        }




    }
}
