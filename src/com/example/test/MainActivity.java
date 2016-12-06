package com.example.test;

import android.support.v7.app.ActionBarActivity;
import android.text.AlteredCharSequence;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
	
	//����һ��Button��TextView
	
	 Button mButton;
	 TextView mTextView;
	 ImageView mImageView;
	 Animation mAnimation;//������
	 Animation mFadein;
	 SoundPool mSoundPool;
	 int yx;
	 
	 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //��Button��TextView��ֵ
        
        mButton=(Button) findViewById(R.id.button1);
        mTextView=(TextView) findViewById(R.id.textView1);
        mImageView=(ImageView) findViewById(R.id.imageView1);//��ö���Ч��
        mAnimation=AnimationUtils.loadAnimation(this,R.anim.zoomin); 
        //�ղż��еĴ��븴�Ƶ�������ط���   
     	mSoundPool=new SoundPool(1,AudioManager.STREAM_MUSIC, 0);
    	yx=mSoundPool.load(this,R.raw.yx,1);
        
    mFadein=AnimationUtils.loadAnimation(this,R.anim.fadein);
        
        //�������ť����һ��������
        mButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String answer="���";
				mTextView.setText(answer);
			mTextView.startAnimation(mFadein);
				mImageView.startAnimation(mAnimation);
				playSound();
				toast("����toast��ʾ��");
				
			}
		});
    }
    
    
    private void showDialog(){
    	AlertDialog.Builder	mBuilder=new AlertDialog.Builder(this);
    	mBuilder.setTitle("��ܰ��ʾ��Ӵ");
    	mBuilder.setMessage("Ҫ����˳��ˣ�ȷ����");
    	mBuilder.setPositiveButton("YES", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
				MainActivity.this.finish();	
			}
		});
    	
    	mBuilder.setNegativeButton("EXIT",new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
    	
    	mBuilder.create().show();
    	
    }
    
    
    
    @Override
	public void onBackPressed() {
    	showDialog();
		
	}


	//���ﴴ��һ����ʾ�ķ���
    private void toast(String content){
    	Toast mToast=Toast.makeText(this,content,Toast.LENGTH_LONG);
    	mToast.setGravity(Gravity.CENTER,0,0);
    	mToast.show();
    	
   
    	//Ҳ������ʾһ����������
    	//System.out.println("��ʾ������");
    	
    }
       
    //�������½�һ����Ч���ŵķ���
    private void playSound(){
//    	mSoundPool=new SoundPool(1,AudioManager.STREAM_MUSIC, 0);
//    	int yx=mSoundPool.load(this,R.raw.yx,1);
    	mSoundPool.play(yx,1,1,0,0,1);//�����ŵ�����ͻ��в�ͬ�ķ�������˵��
    	
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
