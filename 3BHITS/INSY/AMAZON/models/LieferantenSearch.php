<?php

namespace app\models;

use yii\base\Model;
use yii\data\ActiveDataProvider;
use app\models\Lieferanten;

/**
 * LieferantenSearch represents the model behind the search form of `app\models\Lieferanten`.
 */
class LieferantenSearch extends Lieferanten
{
    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['LieferantenID'], 'integer'],
            [['Lieferantenname', 'Lieferanten_Email'], 'safe'],
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
        $query = Lieferanten::find();

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
            'LieferantenID' => $this->LieferantenID,
        ]);

        $query->andFilterWhere(['like', 'Lieferantenname', $this->Lieferantenname])
            ->andFilterWhere(['like', 'Lieferanten_Email', $this->Lieferanten_Email]);

        return $dataProvider;
    }
}
