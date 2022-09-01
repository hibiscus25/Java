package B_ReadMe.B9_Collection;

import java.util.Stack;

//---- создаем на Java какую-то карточную игру. Колода карт лежит на столе. Отыгранные карты отправляются в сброс ------
    class Card {
        private String name;

        public Card(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Card{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public class WStack3 {
        private Stack<Card> deck;                   //  1-й стек для колоды
        private Stack<Card> graveyard;              //  2-й стек для сброса

        //--------------------------- внутри методов вызываются методы класса Stack ------------------------------------
        public Card getCardFromDeck() {             // взять карту из колоды
            return deck.pop();
        }
        // pop()    —   удаляет верхний элемент из стека и возвращает его
        //              метод идеально подходит для реализации механики “игрок берет карту”

        public void discard(Card card) {            // сбросить карт
            graveyard.push(card);
        }
        // push()   —   добавляет элемент на верх стека
        //              когда отправляем карту в сброс, она ложится поверх сброшенных ранее карт

        public Card lookTopCard() {                 // посмотреть верхнюю карту
            return deck.peek();
        }
        // peek()   — возвращает верхний элемент стека, но не удаляет его из стека

        public Stack<Card> getDeck() {
            return deck;
        }

        public Stack<Card> getGraveyard() {
            return graveyard;
        }

        public void setDeck(Stack<Card> deck) {
            this.deck = deck;
        }

        public void setGraveyard(Stack<Card> graveyard) {
            this.graveyard = graveyard;
        }

        public static void main(String[] args) {
            //  создаем колоду и добавляем в нее карты
            Stack<Card> deck = new Stack<>();
                deck.push(new Card("Рагнарос"));
                deck.push(new Card("Пират Глазастик"));
                deck.push(new Card("Сильвана Ветрокрылая"));
                deck.push(new Card("Миллхаус Манашторм"));
                deck.push(new Card("Эдвин ван Клифф"));

            //  создаем сброс
            Stack<Card> graveyard = new Stack<>();

            //  начинаем игру
            WStack3 game = new WStack3();
                game.setDeck(deck);
                game.setGraveyard(graveyard);

            //  первый игрок берет 3 карты из колоды
            Card card1 = game.getCardFromDeck();
            Card card2 = game.getCardFromDeck();
            Card card3 = game.getCardFromDeck();

            System.out.println("Какие карты достались первому игроку?");
            System.out.println(card1);
            System.out.println(card2);
            System.out.println(card3);

            //  первый игрок отправляет в сброс 3 своих карты
                game.discard(card1);
                game.discard(card2);
                game.discard(card3);

            System.out.println("Какие карты находятся в сбросе?");
            System.out.println(game.getGraveyard().pop());
            System.out.println(game.getGraveyard().pop());
            System.out.println(game.getGraveyard().pop());
        }
    }
