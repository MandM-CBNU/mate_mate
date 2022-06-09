package com.example.meetandmeet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
public class Flower_InfoFragment extends Fragment {

    private int[] posterID = {
            R.drawable.flwr1, R.drawable.flwr2, R.drawable.flwr3,
            R.drawable.flwr4, R.drawable.flwr5, R.drawable.flwr6,
            R.drawable.flwr7, R.drawable.flwr8, R.drawable.flwr9,
            R.drawable.flwr10, R.drawable.flwr11, R.drawable.flwr12
    };
    private String[] msgID = {//Todo.꽃말 설명 글로 변경 필요
            "Viola spp. × Violet\n" +
                    "나를 생각해 주세요, 순진한 사랑\n" +
                    "아지랑이 피어오르는 봄이면 양지바른 곳 어디든 보랏빛을 발산하며 소담스럽게 피어있는 꽃이 있다. 오랑캐꽃, 씨름꽃, 병아리꽃, 장수꽃 등 여러 이명을 갖고 있는 제비꽃이다. 오른편 노란색 종은 고산에서 만날수 있는 노랑제비꽃이다.\n",
            "Myosotis alpestris × Forget-me-not\n" +
                    "진실한 사랑, 나를 잊지 마세요.\n" +
                    "물망초를 보면 Pale blue 라는 애틋한 색이 떠오른다. 사랑하는 이에게 꽃을 바치려 했다가 죽음을 맞이한 어느 청년의 영혼이 담긴 꽃이기도 하다.\n",
            "Prunus × yedoensis\n" +
                    " 중간고사, 아름다운 정신(영혼), 정신적 사랑, 삶의 아름다움\n" +
                    "그 외에도 절세미인, 삶의 덧없음과 아름다움, 순결, 뛰어난 아름다움, 정신미, 교양, 부, 그리고 번영을 뜻한다.벚꽃은 벚나무속(Prunus) 벚나무아속(subg. Japanese cherry) 벚나무절(sect. Cerasus) 식물의 꽃이다. 특히 동아시아의 벚나무 종의 나무에서 피는 꽃을 말한다. 히말라야 지역이 원산이라는 이야기도 있으며, 현재는 일본, 한국, 네팔, 대만, 이란, 미국 등 북반구의 온대지역 전역에서 핀다.\n",
            "Delphinium × delphin\n" +
                    "가벼움, 경솔, 제 마음을 헤아려 주세요.\n" +
                    "명의 'Delphinium'은 그리스어의 'delphin(돌고래)'이라는 뜻으로 꽃봉오리가 돌고래와 비슷한 데서 붙여졌으며, 200여 종이 알려져 있다.\n",
            "Tulipa gesneriana x tulip\n" +
                    "헛된 사랑 혹은 사랑의 표시(혼자하는 사랑)\n" +
                    "네덜란드의 국화이기도 하며 네덜란드하면 떠오르는 꽃이지만 사실 원산지는 터키로 오늘날에도 터키의 국화로도 남아있다. 본래 lale(랄레)라고 불리던 튤립은 마치 터번(Turban)처럼 생긴 생김새 때문에 Tülbend(튈벤드)라는 별칭을 갖고 있었는데, 이것이 라틴어 tulipa와 프랑스어 tulipan을 거쳐 영어로 받아들여서 Tulip이 되었다. 터키 사람들은 이 꽃을 관상용으로 기르고 다양한 품종을 만들어냈는데, 오늘날에도 터키인의 튤립 사랑은 남다를 정도로 전통 도자기 등에서도 튤립의 모습을 쉽게 찾아볼 수 있다.\n",
            "Rose x Rosa\n" +
                    "사랑, 아름다움, 낭만적인 사랑, 용기, 존경, 열망, 열정\n" +
                    "장미과 장미속의 관목을 통틀어 이르는 말이다. 높이는 2~3m이며 잎은 어긋나고 깃 모양으로, 5~6월에 담홍색, 담자색, 흰색 등의 꽃이 피고는 한다. 개량 품종이 많은 관상 꽃나무이다. 북반구의 온대와 아한대에 주로 분포한다. 장미는 광을 매우 좋아하는 식물이며 물빠짐이 좋고 공기유통이 비옥한 사양토에서 잘 자란다.\n",
            "Helianthus annuus x Sunflower\n" +
                    "동경, 숭배\n" +
                    "흔히 '해바라기 같은 사람' 하면 자기 주관 없이 이래도 흥, 저래도 흥, 아니면 누군가에 잘 보이려고 아부하는 사람 쯤으로 생각한다. 하지만 이 식물의 꽃말이나 자라는 모습을 보면 그건 잘못된 얘기다. 확고한 자기 주관을 내면 깊숙이 갖고 있으면서 잘 익을수록 고개를 숙이는 겸손을 보여 주며, 진정으로 존경하거나 사랑하는 사람을 흠모할 줄 아는 꽃이다. 자라는 모습도 결코 옆으로 퍼지거나 다른 식물에 기대지 않고 스스로 꿋꿋하게 잘 자란다. 그러니 앞으로 '해바라기 같은 사람' 하면 진심으로 누군가를 존경하고 사랑할 줄 아는 그릇 큰 사람을 지칭하는 말로 인식이 바뀌었으면 좋겠다.\n",
            "Trifolium spp. x Clover\n" +
                    "희망이 이뤄짐, 행운\n" +
                    "행운을 가져다 준다는 네잎크로버, 잔디밭에서는 골치아픈 존재지만 사람들에게 희망, 행운 등 긍정적인 의미를 주는 식물이다.\n",
            "Salvia rosmarinus x Rosemary\n" +
                    "나를 생각해요, 당신의 존재로 나를 소생시키다, 행복한 추억,기억, 가정의 행복\n" +
                    "어원은 라틴어로 '바다의 이슬'이라는 뜻을 가진 'Ros Marinus'(로스 마리누스)에서 따왔다. 꽃은 온대기후 지방에서 봄철부터 여름철에 걸쳐서 피며 원산지는 지중해와 캅카스 지역이다. 높이가 드물게는 2 m까지도 자랄 수 있다.\n",
            "Chrysanthemum morifolium x Asteraceae\n" +
                    "밝은 마음, 실연, 고상\n" +
                    "국화는 관상용으로 널리 재배되므로 원예품종이 많다. 높이 1 m 정도로 줄기 밑부분이 목질화하고, 잎은 어긋나고 깃꼴로 갈라진다. 꽃은 두상화로 줄기 끝에 피는데 가운데는 관상화, 주변부는 설상화이다. 설상화는 암술만 가진 단성화이고 관상화는 암·수술을 모두 달고 있는 양성화이다.\n",
            "Eucalyptus spp. x Mountain gum\n" +
                    "추억\n" +
                    "‘유칼리’ 하면 떠오르는 동물이 하나 있다. 바로 ‘코알라’, 코알라 덕분에 더 많이 알려진 식물이기도 하다. 꽃말은 이미 지나버린 가을을 생각나게 한다.,\n",
            "Camellia x Camellia L.\n" +
                    "기다림, 애타는 사랑, 누구보다 그대를 사랑한다, 비밀스러운 사랑, 굳은 약속, 손을 놓지 않는다, 신중, 당신의 아름다움, 당신의 사랑이 나를 아름답게 한다\n" +
                    "꽃 자체가 상당히 수려한데다가 풍경이 황량해지는 겨울에만 피고, 특히 아열대기후가 아니면 겨울에 피는 수려함을 볼 수 없는 꽃이기 때문에 인기가 높다. 한반도에서는 남해안에 접한 부울경, 전라남도 지역과 제주도에 주로 서식한다. 서울 등 중부지방은 추워서 원래라면 자생하기 힘든 환경이지만 지구 온난화 때문에 21세기 들어서는 늘어난 편이다. 그래도 부산, 여수 등 남해안에서 동백꽃을 많이 볼 수 있다.\n"
    };
    private Flower_InfoAdapter adapter=null;
    private GridView gridView=null;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_flower_info, container, false);
        gridView=(GridView)view.findViewById(R.id.flwrgridview);
        adapter=new Flower_InfoAdapter(getActivity(),posterID,msgID);
        gridView.setAdapter(adapter);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}