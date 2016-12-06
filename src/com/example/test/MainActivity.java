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
	
	//声明一个Button和TextView
	
	 Button mButton;
	 TextView mTextView;
	 ImageView mImageView;
	 Animation mAnimation;//动画类
	 Animation mFadein;
	 SoundPool mSoundPool;
	 int yx;
	 
	 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //给Button和TextView赋值
        
        mButton=(Button) findViewById(R.id.button1);
        mTextView=(TextView) findViewById(R.id.textView1);
        mImageView=(ImageView) findViewById(R.id.imageView1);//获得动画效果
        mAnimation=AnimationUtils.loadAnimation(this,R.anim.zoomin); 
        //刚才剪切的代码复制到了这个地方了   
     	mSoundPool=new SoundPool(1,AudioManager.STREAM_MUSIC, 0);
    	yx=mSoundPool.load(this,R.raw.yx,1);
        
    mFadein=AnimationUtils.loadAnimation(this,R.anim.fadein);
        
        //给这个按钮增加一个监听器
        mButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String answer="你好";
				mTextView.setText(answer);
			mTextView.startAnimation(mFadein);
				mImageView.startAnimation(mAnimation);
				playSound();
				toast("这是toast提示！");
				
			}
		});
    }
    
    
    private void showDialog(){
    	AlertDialog.Builder	mBuilder=new AlertDialog.Builder(this);
    	mBuilder.setTitle("温馨提示你哟");
    	mBuilder.setMessage("要真的退出了！确定吗？");
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


	//这里创建一个提示的方法
    private void toast(String content){
    	Toast mToast=Toast.makeText(this,content,Toast.LENGTH_LONG);
    	mToast.setGravity(Gravity.CENTER,0,0);
    	mToast.show();
    	
   
    	//也可以显示一个输出的语句
    	//System.out.println("显示的内容");
    	
    }
       
    //在这里新建一个音效播放的方法
    private void playSound(){
//    	mSoundPool=new SoundPool(1,AudioManager.STREAM_MUSIC, 0);
//    	int yx=mSoundPool.load(this,R.raw.yx,1);
    	mSoundPool.play(yx,1,1,0,0,1);//把鼠标放到上面就会有不同的方法解释说明
    	
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
