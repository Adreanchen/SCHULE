<?php

namespace app\models;

use yii\base\Model;
use yii\data\ActiveDataProvider;
use app\models\Kunden;

/**
 * KundenSearch represents the model behind the search form of `app\models\Kunden`.
 */
class KundenSearch extends Kunden
{
    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['KundenID'], 'integer'],
            [['Kundenname', 'Kunden_Email'], 'safe'],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function scenarios()
    {
        // bypass scenarios() implementation in the parent class
        return Model::scenarios();
    }

    /**
     * Creates data provider instance with search query applied
     *
     * @param array $params
     * @param string|null $formName Form name to be used into `->load()` method.
     *
     * @return ActiveDataProvider
     */
    public function search($params, $formName = null)
    {
        $query = Kunden::find();

        // add conditions that should always apply here

        $dataProvider = new ActiveDataProvider([
            'query' => $query,
        ]);

        $this->load($params, $formName);

        if (!$this->validate()) {
            // uncomment the following line if you do not want to return any records when validation fails
            // $query->where('0=1');
            return $dataProvider;
        }

        // grid filtering conditions
        $query->andFilterWhere([
            'KundenID' => $this->KundenID,
        ]);

        $query->andFilterWhere(['like', 'Kundenname', $this->Kundenname])
            ->andFilterWhere(['like', 'Kunden_Email', $this->Kunden_Email]);

        return $dataProvider;
    }
}
